package com.coherentsolutions.training.automation.web.sirbu.utilities;

import com.coherentsolutions.training.automation.web.sirbu.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;

        if (driver != null) {

            byte[] screenshotBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshotBytes);


            Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserInfo = String.format("%s Version: %s", caps.getBrowserName(), caps.getBrowserVersion());
            attachBrowserInfo(browserInfo);
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(byte[] screenshotBytes) {
        return screenshotBytes;
    }

    @Attachment(value = "Browser Information", type = "text/plain")
    public String attachBrowserInfo(String browserInfo) {
        return browserInfo;
    }
}