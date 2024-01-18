package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WaitUtils waitUtils;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get(ConfigReader.getInstance().getUrl());
        waitUtils = new WaitUtils(driver);
    }

    protected <T> T initPage(Class<T> pageClass, String... args) {
        try {
            if (args.length > 0) {
                return pageClass.getConstructor(WebDriver.class, String.class).newInstance(driver, args[0]);
            } else {
                return pageClass.getConstructor(WebDriver.class).newInstance(driver);
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize page object: " + pageClass.getSimpleName(), e);
        }
    }

}