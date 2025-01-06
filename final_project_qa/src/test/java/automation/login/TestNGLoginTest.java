package automation.login;

import java.io.IOException;
import java.util.HashMap;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.finalprojectqa.pageObjects.LoginPage;

import components.InitialTestDriver;

public class TestNGLoginTest extends InitialTestDriver {
    LoginPage loginPage ;

    @BeforeTest
    public void setUp() throws IOException{
        System.out.println("ini hasilnadafga");
        loginPage = launchApplication();
    }
    // @Test(dataProvider = "Authentication Success")
    // public void successLogin(HashMap<String, String> user) throws IOException, InterruptedException {
       
    //     loginPage.loginAuth(user.get("username"), user.get("password"));
    //     loginPage.getElementLoginButton().click();
    //     // Assert.assertTrue(loginPage.verifyInHomePage().getText().contains("Swag Labs"));
    //     closeDriver();
    // }

    @Test(dataProvider = "Authentication Fail")
    public void failLogin(HashMap<String, String> user) throws IOException, InterruptedException {
        loginPage.loginAuth(user.get("username"), user.get("password"));
        loginPage.getElementLoginButton().click();
        Boolean isShowErrorMesage = loginPage.isShowErrorMesage();
        Assert.assertTrue(isShowErrorMesage);
        // closeDriver();
    }

    @AfterTest
    public void close(){
        System.out.println("hasilnya asdalah");
        driver.close();
    }

    @DataProvider(name = "Authentication Success")
    public Object[][] credentials() {
        HashMap<String, String> user1 = new HashMap<String, String>();
        user1.put("username", "standard_user");
        user1.put("password", "secret_sauce");
        return new Object[][] { { user1 } };
    }

    @DataProvider(name = "Authentication Fail")
    public Object[][] credentialsFail() {
        HashMap<String, String> user1 = new HashMap<String, String>();
        user1.put("username", "standard_user_fail");
        user1.put("password", "secret_sauce_fail");
        return new Object[][] { { user1 } };
    }

}
