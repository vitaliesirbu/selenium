package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotTestListener;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Listeners ({ScreenshotTestListener.class})
public class BaseTest {
    public WebDriver driver;
    protected WaitUtils waitUtils;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        configReader = ConfigReader.getInstance("config.properties");
        String env = configReader.getProperty("env");

        if ("SAUCELABS".equalsIgnoreCase(env)) {

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setCapability("platformName", "Windows 10");
            browserOptions.setCapability("browserVersion", "latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-vitalie.sirbu0-c4836");
            sauceOptions.put("accessKey", "68eb1fe7-e229-43ff-ae1a-0c6db80dbe78");
            sauceOptions.put("build", "selenium-build-UW9U5");
            sauceOptions.put("name", "<your test name>");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } else {

            String downloadPath = configReader.getProperty("download.path");
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", downloadPath);
            options.setExperimentalOption("prefs", prefs);
            driver = WebDriverSingleton.getDriver(options);
        }

        String url = configReader.getProperty("url");
        driver.get(url);
        waitUtils = new WaitUtils(driver);
    }
}