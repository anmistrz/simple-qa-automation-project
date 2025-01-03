package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.finalprojectqa.pageObjects.LoginPage;

public class InitialTest {
    public WebDriver driver;

    public WebDriver initialWebDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/GlobalData.properties");
        properties.load(inputStream);
        String browser = properties.getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            default:
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        return driver;
    }

    public LoginPage launchApplication() throws IOException {
        this.driver = initialWebDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToMainPage();
        return loginPage;
    }

    public WebDriver closeDriver() {
        driver.close();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
