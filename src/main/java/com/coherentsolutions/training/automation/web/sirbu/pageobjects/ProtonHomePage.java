package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProtonHomePage extends BasePage{

    private static final By LOGGED_IN_LOCATOR = new By.ByXPath("//h2[@title='Inbox']");

    @Override
    public boolean isOpened() {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGGED_IN_LOCATOR));
        return WebElementUtils.isElementDisplayed(loggedInElement);
    }

    public ProtonHomePage(WebDriver driver) {
        super(driver);
    }


}

