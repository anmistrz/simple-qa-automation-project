package stepdefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.finalprojectqa.pageObjects.LoginPage;
import com.finalprojectqa.pageObjects.checkout.CheckoutOverviewPage;
import com.finalprojectqa.pageObjects.checkout.CheckoutPage;
import com.finalprojectqa.pageObjects.checkout.InformationCheckoutPage;
import com.finalprojectqa.pageObjects.dashboard.ProductListDashboardPage;

import components.InitialTestDriver;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsCheckout {
    LoginPage loginPage;
    CheckoutPage checkoutPage;
    InformationCheckoutPage informationCheckoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    WebDriver driver = Hooks.getDriver();

    @Given("I am in the homepage from login with {string} and {string}")
    public void i_am_in_the_homepage(String username, String password) throws IOException, InterruptedException {
        // loginPage = launchApplication();
        loginPage = new LoginPage(driver);
        loginPage.goToMainPage();
        loginPage.loginAuth(username, password);
        loginPage.getElementLoginButton().click();
        loginPage.verifyInHomePage().getText().contains("Swag Labs");
    }

    @When("^I click the add to cart button (.*)$")
    public void i_click_the_product(String product) {
        loginPage.verifyInHomePage().getText().contains("Swag Labs");

        List<String> products = Arrays.asList(product.split(","));

        this.checkoutPage = new CheckoutPage(driver);
        checkoutPage.addItemsToCart(products);
    }

    @And("I click the cart button")
    public void i_click_the_cart_button() {
        checkoutPage.goToCheckoutPage();
        Assert.assertTrue(checkoutPage.verifyInCheckoutPage().getText().contains("Your Cart"));
    }

    @And("I click the checkout button")
    public void i_click_the_checkout_button() {
        checkoutPage.checkout();
    }

    @And("I fill in the checkout information with {string}, {string}, and {string}")
    public void i_fill_in_the_checkout_information_with_and(String firstName, String lastName, String postalCode) throws InterruptedException {
        this.informationCheckoutPage = new InformationCheckoutPage(driver);
        informationCheckoutPage.fillInformation(firstName, lastName, postalCode);
        Thread.sleep(1000);
        informationCheckoutPage.verifyDataInformationNotNull();
    }

    @And("I click the continue button")
    public void i_click_the_continue_button() {
        informationCheckoutPage.clickContinueButton();
    }

    @And("I verify the products before finishing the purchase (.*)$")
    public void i_verify_the_products_before_finishing_the_purchase(String products) {
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);

        List<String> productsList = Arrays.asList(products.split(","));
        List<WebElement> listProductOverview = checkoutOverviewPage.getCheckoutCardList();

        for (int i = 0; i < listProductOverview.size(); i++) {
            Assert.assertTrue(listProductOverview.get(i).getText().contains(productsList.get(i)));
        }
        checkoutOverviewPage.verifyTotalPrice();
    }

    @And("I click the finish button")
    public void i_click_the_finish_button() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("I should see the thank you message")
    public void i_should_see_the_thank_you_message() {
        checkoutOverviewPage.verifySuccessCheckout();
        // closeDriver();
    }






}
