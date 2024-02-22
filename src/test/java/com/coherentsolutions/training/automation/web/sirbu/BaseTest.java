package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ScreenshotTestListener;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebDriverSingleton;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
    @Parameters({"platform", "browserName", "browserVersion"})
    public void setUp(@Optional String platform, @Optional String browserName, @Optional String browserVersion) throws MalformedURLException {

        configReader = ConfigReader.getInstance("config.properties");
        String env = configReader.getProperty("env");

        if ("SAUCELABS".equalsIgnoreCase(env)) {

            MutableCapabilities browserOptions = new MutableCapabilities();
            if (platform != null && browserName != null && browserVersion != null) {
                browserOptions.setCapability("platformName", platform);
                browserOptions.setCapability("browserName", browserName);
                browserOptions.setCapability("browserVersion", browserVersion);
            }

            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-vitalie.sirbu0-c4836");
            sauceOptions.put("accessKey", "68eb1fe7-e229-43ff-ae1a-0c6db80dbe78");
            sauceOptions.put("build", "selenium-build-UW9U5");
            sauceOptions.put("name", "<your test name>");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);

        } else if ("SELENOID".equalsIgnoreCase(env)) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        } else {

            String downloadPath = configReader.getProperty("download.path");
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", downloadPath);
            options.setExperimentalOption("prefs", prefs);
            driver = WebDriverSingleton.getDriver(options);
        }

        String url = configReader.getProperty("url");
        driver.get(ConfigReader.getInstance(String.valueOf(getClass())).getUrl());
        waitUtils = new WaitUtils(driver);
    }
}