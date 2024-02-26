package com.coherentsolutions.training.automation.web.sirbu.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementUtils {

    public static boolean isOpened(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
