package com.finalprojectqa.helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {
    WebDriver driver;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibilityOfElement(WebElement element) {
        // wait for element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibilityOfElement(By addCheckoutButton) {
        // wait for element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCheckoutButton));
    }

}
