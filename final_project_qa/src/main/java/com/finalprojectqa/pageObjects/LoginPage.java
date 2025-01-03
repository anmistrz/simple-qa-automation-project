package com.finalprojectqa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectqa.helper.HelperMethods;

public class LoginPage extends HelperMethods {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement homepage;

    public void loginAuth(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void goToMainPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public Boolean isShowErrorMesage() throws InterruptedException {
        HelperMethods helperMethods = new HelperMethods(driver);
        helperMethods.waitVisibilityOfElement(errorMessage);

        if (errorMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }   
    }

    public WebElement verifyInHomePage() {
        HelperMethods helperMethods = new HelperMethods(driver);
        helperMethods.waitVisibilityOfElement(homepage);

        if (homepage.isDisplayed()) {
            return homepage;
        } else {
            return null;
        }
    }

    public WebElement getElementLoginButton () {
        return loginButton;
    }


}
