package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginLogoutTestLocal extends BaseTestLocal {

    private LoginPage loginPage;
    private HomePage homePage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    private String username = configReader.getProperty("username");
    private String password = configReader.getProperty("password");
    private String expectedResult = configReader.getProperty("expectedResult");

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    protected void login(String username, String password) {
        loginPage.login(username, password);
    }

    protected void logout() {
        homePage.logout();
    }

    @Test(priority = 1, groups = {"loginGroup"}, description = "This test verifies login functionality.")
    @Epic("Authentication")
    @Feature("Login")
    @Story("Valid Login")

    public void testSuccessfulLogin() {
        login(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> homePage.isLoggedIn());

        String loggedInText = homePage.welcomeText();

        Assert.assertEquals(loggedInText, expectedResult, "The actual result does not match the expected result.");
        System.out.println("Actual result matches expected result: " + loggedInText);
    }

    @Test(priority = 2, groups = {"logoutGroup"}, description = "This test verifies that user can successfully logout.")
    @Epic("Authentication")
    @Feature("Logout")
    @Story("Valid Logout")
    public void testSuccessfulLogout() {
        login(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver) -> homePage.isLoggedIn());
        logout();
        Assert.assertFalse(homePage.isLoggedIn(), "User is still logged in when they should be logged out.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}