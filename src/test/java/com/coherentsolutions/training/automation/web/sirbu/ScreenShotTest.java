package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.ProtonHomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.ProtonLoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ScreenShotTest extends BaseTest{

    private ProtonLoginPage loginPage;
    private ProtonHomePage homePage;

    private String username = ConfigReader.getInstance().getUsername();
    private String password = ConfigReader.getInstance().getPassword();

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new ProtonLoginPage(driver, ConfigReader.getInstance().getUrl());
        homePage = initPage(ProtonHomePage.class);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login(username, password);
        Assert.assertTrue(homePage.isOpened());
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void homePageScreenShotTest() {
        By elementLocator = By.xpath("//h2[@title='Inbox']");
        waitUtils.waitForElementPresence(elementLocator, 5);
        String screenshotDestination = "Screenshots/homepage_screenshot.png";
        ScreenshotUtil.captureAndSaveScreenshot(driver, screenshotDestination);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
