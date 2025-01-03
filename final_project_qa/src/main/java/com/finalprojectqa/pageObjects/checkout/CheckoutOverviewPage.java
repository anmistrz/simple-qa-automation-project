package com.finalprojectqa.pageObjects.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectqa.helper.HelperMethods;

public class CheckoutOverviewPage extends HelperMethods {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//div[@class='cart_item']"))
    List<WebElement> cartListOverview;

    @FindBy(xpath = "//div[@data-test='total-label']")
    WebElement totalPriceElement;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    WebElement taxPriceElement;

    @FindBy(id = "finish")
    WebElement buttonFinish;

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    WebElement completeHeader;


    public List<WebElement> getCheckoutCardList () {
        return cartListOverview;
    }

    public Boolean verifyTotalPrice () {
        List<WebElement> priceList = new ArrayList<WebElement>();
        double totalPrice = 0;

        priceList = cartListOverview.stream().map(e -> e.findElement(By.xpath(".//div[@class='inventory_item_price']")))
                .collect(Collectors.toList());

        for (WebElement price : priceList) {
            String priceText = price.getText().replace("$", "");
            totalPrice += Double.parseDouble(priceText);
        }

        String priceElementText = totalPriceElement.getText().replace("Total: $", "");
        double priceElementDouble = Double.parseDouble(priceElementText);

        String taxPriceElementText = taxPriceElement.getText().replace("Tax: $", "");
        double taxPriceElementDouble = Double.parseDouble(taxPriceElementText);

        System.out.println("Total price: " + totalPrice);


        if ((totalPrice + taxPriceElementDouble) == priceElementDouble) {
            return true;
        } else {
            return false;
        }
    }

    public void clickFinishButton() {
        buttonFinish.click();
    }

    public Boolean verifySuccessCheckout() {
        HelperMethods helperMethods = new HelperMethods(driver);
        helperMethods.waitVisibilityOfElement(completeHeader);

        if (completeHeader.isDisplayed()) {
            return true;
        } else {
            return false;
        }
        
    }


}
