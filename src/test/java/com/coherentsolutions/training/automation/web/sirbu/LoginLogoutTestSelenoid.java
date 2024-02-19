package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginLogoutTestSelenoid extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    private String username = configReader.getProperty("username");
    private String password = configReader.getProperty("password");
    private String expectedResult = configReader.getProperty("expectedResult");

    @BeforeMethod
    @Override
    public void setUp() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), options);

        } catch (MalformedURLException e){
            e.printStackTrace();
        }
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

    public void testSuccessfulLogin() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");

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
        driver.get("https://magento.softwaretestingboard.com/");
        login(username, password);
        logout();
        Assert.assertFalse(homePage.isLoggedIn(), "User is still logged in when they should be logged out.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}