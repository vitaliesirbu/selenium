package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    protected WaitUtils waitUtils;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.get(ConfigReader.getInstance(String.valueOf(getClass())).getUrl());
        waitUtils = new WaitUtils(driver);
    }
}