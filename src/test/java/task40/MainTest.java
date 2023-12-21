package task40;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private static final String LOGIN_PAGE_URL = "https://magento.softwaretestingboard.com/";

    private WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @DataProvider(name = "credentialsProvider")
    public Object[][] credentialsData() {
        return new Object[][]{
                {"johnycage@mk3.com", "Qwerty123!", "Johny"},
                {"liukang@mk3.com", "Qwerty123!", "Liu"}
        };
    }

    @Test(dataProvider = "credentialsProvider")
    void testLogin(String email, String password, String expectedUserName) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, LOGIN_PAGE_URL);
        String actualResult = loginPage.logedin(email, password);
        System.out.println("Actual Result: " + actualResult);
        Assert.assertTrue(actualResult.contains(expectedUserName), "Login with user [" + expectedUserName + "] failed");
    }

    @AfterMethod
    void cleanUp(){
        driver.quit();
    }
}
