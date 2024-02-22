package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.ProtonHomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.ProtonLoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotUtil;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class ScreenShotTest extends BaseTest {

    private ProtonLoginPage loginPage;
    private ProtonHomePage homePage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    private String username = configReader.getProperty("username");
    private String password = configReader.getProperty("password");

    @BeforeMethod
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        loginPage = new ProtonLoginPage(driver);
        homePage = new ProtonHomePage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login(username, password);
        homePage.isOpened();
        By elementLocator = By.xpath("//button[normalize-space()='New message']");
        waitUtils.waitForElementToBeClickable(elementLocator, 5);
        String screenshotDestination = "Screenshots/homepage_screenshot.png";
        ScreenshotUtil.captureAndSaveScreenshot(driver, screenshotDestination);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
