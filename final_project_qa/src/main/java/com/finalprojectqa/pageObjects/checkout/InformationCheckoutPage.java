package com.finalprojectqa.pageObjects.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectqa.helper.HelperMethods;

public class InformationCheckoutPage extends HelperMethods {

    WebDriver driver;

    public InformationCheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    public void fillInformation(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    public Boolean verifyDataInformationNotNull() {
        if (firstName.getDomAttribute("value").isEmpty() || lastName.getDomAttribute("value").isEmpty()
                || postalCode.getDomAttribute("value").isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
