package com.finalprojectqa.pageObjects.dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectqa.helper.HelperMethods;

public class ProductListDashboardPage extends HelperMethods {
    WebDriver driver;

    public ProductListDashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> listInventoryItemName;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    List<WebElement> listInventoryItemPrice;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    WebElement selectSortContainer;

    @FindBy(xpath = "//select[@data-test='product-sort-container']//option")
    List<WebElement> listSortOptions;


    public List<WebElement> getListInventoryByFilter(String name) {

        switch (name) {
            case "Name (A to Z)":
                listSortOptions.get(0).click();
                List<WebElement> listInventoryAtoZ = listInventoryItemName;
                listInventoryAtoZ.sort((a, b) -> a.getText().compareTo(b.getText()));
                return listInventoryAtoZ;
            case "Name (Z to A)":
                listSortOptions.get(1).click();
                List<WebElement> listInventoryZtoA = listInventoryItemName;
                listInventoryZtoA.sort((a, b) -> b.getText().compareTo(a.getText()));
                return listInventoryZtoA;
            case "Price (low to high)":
                listSortOptions.get(2).click();
                List<WebElement> listInventoryLowToHigh = listInventoryItemPrice;
                listInventoryLowToHigh.sort((a, b) -> Double.compare(Double.parseDouble(a.getText().replace("$", "")),
                        Double.parseDouble(b.getText().replace("$", ""))));
                return listInventoryLowToHigh;
            case "Price (high to low)":
                listSortOptions.get(3).click();
                List<WebElement> listInventoryHighToLow = listInventoryItemPrice;
                listInventoryHighToLow.sort((a, b) -> Double.compare(Double.parseDouble(b.getText().replace("$", "")),
                        Double.parseDouble(a.getText().replace("$", ""))));
                return listInventoryHighToLow;
            default:
                return null;
        }
    }

    public Boolean verifyItemFilter(String name, List<WebElement> listInventory) {
        switch (name) {
            case "Name (A to Z)":
                for (int i = 0; i < listInventory.size() - 1; i++) {
                    if (listInventory.get(i).getText().compareTo(listInventory.get(i + 1).getText()) > 0) {
                        return false;
                    }
                }
                return true;
            case "Name (Z to A)":
                for (int i = 0; i < listInventory.size() - 1; i++) {
                    if (listInventory.get(i).getText().compareTo(listInventory.get(i + 1).getText()) < 0) {
                        return false;
                    }
                }
                return true;
            case "Price (low to high)":
                for (int i = 0; i < listInventory.size() - 1; i++) {
                    if (Double.parseDouble(listInventory.get(i).getText().replace("$", "")) > Double
                            .parseDouble(listInventory.get(i + 1).getText().replace("$", ""))) {
                        return false;
                    }
                }
                return true;
            case "Price (high to low)":
                for (int i = 0; i < listInventory.size() - 1; i++) {
                    if (Double.parseDouble(listInventory.get(i).getText().replace("$", "")) < Double
                            .parseDouble(listInventory.get(i + 1).getText().replace("$", ""))) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public void clickFilterButton() throws InterruptedException {
        Thread.sleep(2000);
        selectSortContainer.click();
    }

    public List<WebElement> getListInventoryItemName() {
        return listInventoryItemName;
    }

    public List<WebElement> getListInventoryItemPrice() {
        return listInventoryItemPrice;
    }

    public List<WebElement> getListSortOptions() {
        return listSortOptions;
    }
}
