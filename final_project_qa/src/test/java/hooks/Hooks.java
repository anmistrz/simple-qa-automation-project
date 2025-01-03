package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import components.InitialTestDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.I;

public class Hooks {

    // WebDriver instance dari WebDriverFactory
    public static WebDriver driver;
    InitialTestDriver initialTestDriver;

    @Before
    public void setUp() throws IOException {
        // Tentukan browser yang digunakan di sini
        initialTestDriver = new InitialTestDriver();
        driver = initialTestDriver.initialWebDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

     public static WebDriver getDriver() {
        return driver;
    }
}
