package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginLogoutTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private String username;
    private String password;
    private String expectedResult;
    private WaitUtils waitUtils;

    @BeforeClass
    public void setUp(){
        driver = WebDriverSingleton.getDriver();
        driver.get(ConfigReader.getInstance().getUrl());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        username = ConfigReader.getInstance().getUsername();
        password = ConfigReader.getInstance().getPassword();
        expectedResult = ConfigReader.getInstance().getExpectedResult();
        waitUtils = new WaitUtils(driver);;
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        loginPage.login(username,password);
        waitUtils.waitForElementPresence(homePage.getLoggedInLocator(), 5);
        String loggedInText = homePage.welcomeText();
        Assert.assertEquals(loggedInText, expectedResult, "The actual result does not match the expected result.");
        System.out.println("Actual result matches expected result: " + loggedInText);
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void testSuccessfulLogout(){
        homePage.logout();
        waitUtils.waitForElementAbsence(HomePage.getLoggedInLocator(), 5);
        Assert.assertFalse(homePage.isLoggedIn(), "User is still logged in when they should be logged out.");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
