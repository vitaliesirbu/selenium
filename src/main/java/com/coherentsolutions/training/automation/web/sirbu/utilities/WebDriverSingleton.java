package com.coherentsolutions.training.automation.web.sirbu.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(ChromeOptions options) {
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
