package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginLogoutTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriverWait wait;
    private String username;
    private String password;
    private String expectedResult;

    @BeforeClass
    public void setUp(){

        driver = WebDriverSingleton.getDriver();
        driver.get(ConfigReader.getInstance().getUrl());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);


        username = ConfigReader.getInstance().getUsername();
        password = ConfigReader.getInstance().getPassword();
        expectedResult = ConfigReader.getInstance().getExpectedResult();


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver,  Duration.ofSeconds(5));
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        loginPage.login(username,password);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logged-in")));
        String loggedInText = homePage.welcomeText();
        Assert.assertEquals(loggedInText, expectedResult, "The actual result does not match the expected result.");
        System.out.println("Actual result matches expected result: " + loggedInText);
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void testSuccessfulLogout(){
        homePage.logout();
        Assert.assertTrue(isElementPresent(By.className("logged-in")), "Element is not present on the page.");
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
