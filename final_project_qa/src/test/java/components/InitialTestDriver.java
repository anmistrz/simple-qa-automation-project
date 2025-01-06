package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.finalprojectqa.pageObjects.LoginPage;

public class InitialTestDriver {
    public WebDriver driver;
    public String nama;

    public InitialTestDriver(){};

    public WebDriver initialWebDriver() throws IOException {
        if (driver == null) {
            System.out.println("ini adalah null driver");
            System.out.println(driver);
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("src/main/resources/GlobalData.properties");
            properties.load(inputStream);
            String browser = properties.getProperty("browser");

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
                    this.driver = new ChromeDriver();
                    break;
                default:
                    break;
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();

            System.out.println("hasilnya" + driver);
            return driver;
        }
        

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
