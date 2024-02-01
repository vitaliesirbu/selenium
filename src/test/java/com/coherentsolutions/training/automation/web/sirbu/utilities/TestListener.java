package com.coherentsolutions.training.automation.web.sirbu.utilities;

import com.coherentsolutions.training.automation.web.sirbu.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).driver;

        String testName = result.getName();
        String filePath = "target/artifacts/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        ScreenshotUtil.captureAndSaveScreenshot(webDriver, filePath);
    }
}