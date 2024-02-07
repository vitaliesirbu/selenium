package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotTestListener;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.HashMap;
import java.util.Map;

@Listeners ({ScreenshotTestListener.class})
public class BaseTest {
    public WebDriver driver;
    protected WaitUtils waitUtils;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        configReader = ConfigReader.getInstance("config.properties");
        String downloadPath = configReader.getProperty("download.path");

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);

        driver = WebDriverSingleton.getDriver(options);
        driver.get(ConfigReader.getInstance(String.valueOf(getClass())).getUrl());
        waitUtils = new WaitUtils(driver);
    }
}