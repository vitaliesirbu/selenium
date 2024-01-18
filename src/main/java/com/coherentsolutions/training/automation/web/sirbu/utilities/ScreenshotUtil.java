package com.coherentsolutions.training.automation.web.sirbu.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;


public class ScreenshotUtil {

    public static void captureAndSaveScreenshot(WebDriver driver, String destinationFilePath) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshotFile, new File(destinationFilePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
