package task30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static task30.ByVariables2.*;

public class LumaLogin {

    private WebDriver driver;
    final static String URL = "https://magento.softwaretestingboard.com/";
    final static String LOGIN_USER_EMAIL = "vitaliesirbu@coherentsolutions.com";
    final static String LOGIN_PASSWORD = "Admin123!";

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void loginTest() throws InterruptedException {
        driver.navigate().to(URL);
        WebElement signIn = driver.findElement(signInVar);
        signIn.click();
        WebElement emailInput = driver.findElement(emailInputVar);
        emailInput.sendKeys(LOGIN_USER_EMAIL);
        WebElement passwordInput = driver.findElement(passwordInputVar);
        passwordInput.sendKeys(LOGIN_PASSWORD);
        WebElement signInButton = driver.findElement(signInButtonVar);
        signInButton.click();

        Thread.sleep(2000);

        String expectedResult = "Welcome, Vitalie S!";

        WebElement loggedInElement = driver.findElement(loggedIn);
        String actualResult = loggedInElement.getText();

        Assert.assertEquals(actualResult, expectedResult, "The actual result does not match the expected result.");

        System.out.println("Test Passed: The actual result matches the expected result.");

    }

    @AfterClass
    void cleanUp(){
        driver.quit();
    }
}
