package com.coherentsolutions.training.automation.web.sirbu.pageobjects;


import com.coherentsolutions.training.automation.web.sirbu.utilities.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {
    private static final int LOCATOR_TIMEOUT = 10;

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement logoutLink;

    @FindBy(css = "div[class='panel header'] span[class='logged-in']")
    private WebElement welcomeMessage;

    @Override
    public boolean isOpened() {
        return isLoggedIn();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        return WebElementUtils.isElementDisplayed(welcomeMessage);
    }

    public void logout(){
        new WebDriverWait(driver, Duration.ofSeconds(LOCATOR_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(LOCATOR_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }
    public String welcomeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LOCATOR_TIMEOUT));
        return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(welcomeMessage)
        )).getText();
    }
}
