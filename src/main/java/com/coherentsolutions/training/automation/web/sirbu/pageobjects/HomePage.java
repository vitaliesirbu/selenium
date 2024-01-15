package com.coherentsolutions.training.automation.web.sirbu.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    private WebDriver driver;
    private static final By LOGGED_IN_LOCATOR = By.className("logged-in");

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement logoutLink;

    @FindBy(className = "logged-in")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedIn() {
        try {
            return welcomeMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static By getLoggedInLocator() {
        return LOGGED_IN_LOCATOR;
    }

    public void logout(){
        myAccountButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }
    public String welcomeText(){
        return welcomeMessage.getText();
    }
}
