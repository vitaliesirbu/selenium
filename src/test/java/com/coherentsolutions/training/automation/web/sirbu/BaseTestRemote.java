package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotTestListener;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

@Listeners ({ScreenshotTestListener.class})
public class BaseTestRemote {
    public WebDriver driver;
    protected WaitUtils waitUtils;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        configReader = ConfigReader.getInstance("config.properties");

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-vitalie.sirbu0-c4836");
        sauceOptions.put("accessKey", "68eb1fe7-e229-43ff-ae1a-0c6db80dbe78");
        sauceOptions.put("build", "selenium-build-UW9U5");

        sauceOptions.put("name", "SauceLabTest_Windows10_Chrome");

        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize the Remote WebDriver.", e);
        }

        driver.get(ConfigReader.getInstance(String.valueOf(getClass())).getUrl());
        waitUtils = new WaitUtils(driver);
    }
}