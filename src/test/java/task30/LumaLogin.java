package task30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static task30.ByVariables.*;

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
    void loginTest(){
        driver.navigate().to(URL);
        WebElement signIn = driver.findElement(SignIn);
        signIn.click();
        WebElement emailInput = driver.findElement(EmailInput);
        emailInput.sendKeys(LOGIN_USER_EMAIL);
        WebElement passwordInput = driver.findElement(PasswordInput);
        passwordInput.sendKeys(LOGIN_PASSWORD);
        WebElement signInButton = driver.findElement(SignInButton);
        signInButton.click();

        Assert.assertEquals(driver.findElement(AssertElement).isDisplayed(), true, "Assert Element is not displayed");
        System.out.println("Login test executed successfully.");
    }

    @AfterClass
    void cleanUp(){
        driver.quit();
    }
}
