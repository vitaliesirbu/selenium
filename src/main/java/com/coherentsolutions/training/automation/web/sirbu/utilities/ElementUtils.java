package com.coherentsolutions.training.automation.web.sirbu.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    public static boolean isElementDisplayed(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOf(element))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
