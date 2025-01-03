package automation.checkout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.finalprojectqa.pageObjects.LoginPage;
import com.finalprojectqa.pageObjects.checkout.CheckoutOverviewPage;
import com.finalprojectqa.pageObjects.checkout.CheckoutPage;
import com.finalprojectqa.pageObjects.checkout.InformationCheckoutPage;

import components.InitialTest;
import model.AddCheckoutModel;

public class TestNGCheckout extends InitialTest {
    LoginPage loginPage;

    @BeforeTest
    public void setup() throws IOException {
        loginPage = launchApplication();
    }

    @Test(dataProvider = "Data Checkout", priority = 1)
    public void addCheckout(HashMap<String, AddCheckoutModel> data, String keys) throws IOException {
        loginPage.loginAuth(
            data.get("data1")
            .getUsernameByKeys(data.get(keys).getKey()),
            data.get("data1")
            .getPasswordByKeys(data.get(keys).getKey())
        );

        loginPage.getElementLoginButton().click();
        loginPage.verifyInHomePage().getText().contains("Swag Labs");

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.addItemsToCart(data.get(data.get(keys).getKey()).getItemsByKeys(keys));
        checkoutPage.goToCheckoutPage();

        Assert.assertTrue(checkoutPage.verifyInCheckoutPage().getText().contains("Your Cart"));

        checkoutPage.checkout();

    }

    @Test(dependsOnMethods = "addCheckout", dataProvider = "Verify User Information")
    public void verifyUserInformation(HashMap<String, String> data) throws InterruptedException {
        InformationCheckoutPage informationCheckoutPage = new InformationCheckoutPage(driver);
        informationCheckoutPage.fillInformation(data.get("firstName"), data.get("lastName"), data.get("postalCode"));
        Thread.sleep(500);
        Assert.assertTrue(informationCheckoutPage.verifyDataInformationNotNull());
        informationCheckoutPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "verifyUserInformation", dataProvider = "Data Checkout")
    public void verifyCheckout(HashMap<String, AddCheckoutModel> data, String keys) {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        List<WebElement> items = checkoutOverviewPage.getCheckoutCardList();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item: " + items.get(i).getText());
            System.out.println("ItemBawaan: " + data.get(keys).getItemsByKeys(keys).get(i));
            Assert.assertTrue(items.get(i).getText().contains(data.get(keys).getItemsByKeys(keys).get(i)));
        }

        checkoutOverviewPage.verifyTotalPrice();
        checkoutOverviewPage.clickFinishButton();

        Assert.assertTrue(checkoutOverviewPage.verifySuccessCheckout());
    }

    @AfterTest
    public void close() {
        closeDriver();
    }
    

    @DataProvider(name = "Data Checkout")
    public Object[][] dataCheckout() {
        AddCheckoutModel addCheckoutModel = new AddCheckoutModel("standard_user", "secret_sauce", List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt"), "data1");
        addCheckoutModel.setAddCheckoutModel(addCheckoutModel.getKey(), addCheckoutModel);
        return new Object[][] { { addCheckoutModel.getAddCheckoutModel(addCheckoutModel.getKey()), addCheckoutModel.getKey() } };
    }

    @DataProvider(name = "Verify User Information")
    public Object[][] verifyUserInformation() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("firstName", "John");
        user.put("lastName", "Doe");
        user.put("postalCode", "12345");
        return new Object[][] { { user } };
    }
        
}
