package stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.finalprojectqa.pageObjects.LoginPage;

import components.InitialTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitonsLogin extends InitialTest {
    LoginPage loginPage;

    @Given("I am in the login page")
    public void i_am_in_the_login_page() throws IOException {
        loginPage = launchApplication();
    }

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) throws InterruptedException {
        loginPage.loginAuth(username, password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.getElementLoginButton().click();
    }

    @Then("I should see the homepage")
    public void i_should_see_the_homepage() {
        Assert.assertTrue(loginPage.verifyInHomePage().getText().contains("Swag Labs"));
        closeDriver();
    }

    @Then("I should see the error message")
    public void i_should_see_the_error_message() throws InterruptedException {
        Boolean isShowErrorMesage = loginPage.isShowErrorMesage();
        Assert.assertTrue(isShowErrorMesage);
        closeDriver();
    }

}

