package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseLoginTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WaitUtils waitUtils;

    @BeforeClass
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get(ConfigReader.getInstance().getUrl());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        waitUtils = new WaitUtils(driver);
    }

    protected void login(String username, String password) {
        loginPage.login(username, password);
        waitUtils.waitForElementPresence(homePage.getLoggedInLocator(), 5);
    }

    protected void logout() {
        homePage.logout();
        waitUtils.waitForElementAbsence(HomePage.getLoggedInLocator(), 5);
    }
}