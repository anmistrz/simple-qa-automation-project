package automation.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.finalprojectqa.enums.OptionFilterProductEnum;
import com.finalprojectqa.pageObjects.LoginPage;
import com.finalprojectqa.pageObjects.dashboard.ProductListDashboardPage;

import components.InitialTestDriver;

public class TestNGFilterTest extends InitialTestDriver {
    LoginPage loginPage;
    OptionFilterProductEnum optionFilterProductEnum;

    @BeforeTest
    public void setup() throws IOException {
        loginPage = launchApplication();
    }

    @Test(dataProvider = "Authentication")
    public void login(HashMap<String, String> user) throws IOException {
        loginPage.loginAuth(user.get("username"), user.get("password"));
        loginPage.getElementLoginButton().click();
        loginPage.verifyInHomePage().getText().contains("Swag Labs");
    }

    @Test(dependsOnMethods = "login", dataProvider = "Filter")
    public void filterInventory(HashMap<String, List<String>> filter) throws InterruptedException {
        ProductListDashboardPage productListDashboardPage = new ProductListDashboardPage(driver);
        List<String> dataFilterName = filter.get("filter");
        dataFilterName.stream().forEach(filterName -> {
        try {
            productListDashboardPage.clickFilterButton();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<WebElement> filterList = productListDashboardPage.getListInventoryByFilter(filterName);
        Assert.assertTrue(productListDashboardPage.verifyItemFilter(filterName, filterList));
        });
    } 

    @AfterTest
    public void close() {
        closeDriver();
    }

    @DataProvider(name = "Authentication")
    public Object[][] credentials() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("username", "standard_user");
        user.put("password", "secret_sauce");
        return new Object[][] { { user } };
    }

    @DataProvider(name = "Filter")
    public Object[][] filter() {
        List<String> filters = OptionFilterProductEnum.getFilters();
        HashMap<String, List<String>> filter = new HashMap<String, List<String>>();
        filter.put("filter", filters);
        return new Object[][] { { filter } };
    }
}
