package stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.finalprojectqa.pageObjects.LoginPage;
import com.finalprojectqa.pageObjects.dashboard.ProductListDashboardPage;

import components.InitialTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsFilter extends InitialTest {
    ProductListDashboardPage productListDashboardPage;
    List<WebElement> filterList;
    LoginPage  loginPage;
    
    @When("I click the filter button")
    public void i_filter_product() throws InterruptedException {
        productListDashboardPage = new ProductListDashboardPage(driver);
        productListDashboardPage.clickFilterButton();
    }

    @And("I choose the filter {string}")
    public void i_choose_the_filter_and_see_the_products(String filterName) {
        System.out.println("Filter name: " + filterName);
       filterList = productListDashboardPage.getListInventoryByFilter(filterName);
    }

    @Then("I should see the products filtered by {string}")
    public void i_should_see_the_products_filtered_by(String filterName) {
        System.out.println("Filter name: " + filterName);
        productListDashboardPage.verifyItemFilter(filterName, filterList);
        closeDriver();
    }
}
