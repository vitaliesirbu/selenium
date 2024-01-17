package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTest {

    private String username = ConfigReader.getInstance().getUsername();
    private String password = ConfigReader.getInstance().getPassword();
    private String expectedResult = ConfigReader.getInstance().getExpectedResult();

    @Test
    public void testSuccessfulLogin() {
        login(username, password);
        String loggedInText = homePage.welcomeText();
        Assert.assertEquals(loggedInText, expectedResult, "The actual result does not match the expected result.");
        System.out.println("Actual result matches expected result: " + loggedInText);
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void testSuccessfulLogout() {
        logout();
        Assert.assertFalse(homePage.isLoggedIn(), "User is still logged in when they should be logged out.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}