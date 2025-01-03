package com.finalprojectqa.pageObjects.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectqa.helper.HelperMethods;

public class CheckoutPage extends HelperMethods {
    WebDriver driver;
    List<WebElement> listSelectedProducts;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-test='title']")
    WebElement checkoutTitle;

    @FindBy(xpath = "//div[@class='inventory_list']")
    List<WebElement> inventoryList;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement totalCheckoutElement;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    WebElement buttonGoToCheckoutPage;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    By inventoryName = By.xpath("//div[@data-test='inventory-item-name']");

    public WebElement verifyInCheckoutPage() {
        HelperMethods helperMethods = new HelperMethods(driver);
        helperMethods.waitVisibilityOfElement(checkoutTitle);

        if (checkoutTitle.isDisplayed()) {
            return checkoutTitle;
        } else {
            return null;
        }
    }

    public List<WebElement> getInventoryList() {
        return inventoryList;
    }

    public WebElement verifyTotalCheckoutElement() {
        HelperMethods helperMethods = new HelperMethods(driver);
        helperMethods.waitVisibilityOfElement(totalCheckoutElement);

        if (totalCheckoutElement.isDisplayed()) {
            return totalCheckoutElement;
        } else {
            return null;
        }
    }

    public WebElement getInventoryName(String items) {
        System.out.println("Items In: " + items);
        WebElement product = null;
        for (WebElement inventory : inventoryList) {
            List<WebElement> inventoryNameList = inventory.findElements(inventoryName);
            for (WebElement detailInventoryName : inventoryNameList) {
                System.out.println("InventoryName: " + detailInventoryName.getText());
                if (detailInventoryName.getText().equals(items)) {
                    System.out.println("Match: " + detailInventoryName.getText());
                    product = inventory.findElement(By.xpath("//div[@data-test='inventory-item-name'][contains(text(),'" + items + "')]"));
                    break;
                }
            }
        }
        System.out.println("ProductssssssssssResult: " + product);
        return product;
    }

    public void addItemsToCart(List<String> items) {
        items.forEach(item -> {
            WebElement testProduct = getInventoryName(item);
            System.out.println("ProductssssssssssTest: " + testProduct.getText());

            String idInventoryProduct = makeIdInventoryProductPattern(item);
            WebElement button = testProduct.findElement(By.xpath("//ancestor::div[@class='inventory_item']//button[@id='" + idInventoryProduct + "']"));
            button.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    public String makeIdInventoryProductPattern(String items) {
        String itemsLower = items.toLowerCase();
        String itemsReplace = itemsLower.replace(" ", "-");
        String itemsReplaceAll = itemsReplace.replaceAll("[^a-zA-Z0-9]", "-");
        // Remove - from the beginning and end of the string
        String itemsTrim = itemsReplaceAll.replaceAll("^-|-$", "");
        String itemsId = "add-to-cart-" + itemsTrim;
        return itemsId;
    }

    public void goToCheckoutPage() {
       buttonGoToCheckoutPage.click();
    }

    public void checkout() {
        checkoutButton.click();
    }



}
