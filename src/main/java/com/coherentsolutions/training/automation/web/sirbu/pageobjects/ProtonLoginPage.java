package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProtonLoginPage extends BasePage {

    @FindBy(id="username")
    private WebElement emailField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;


    public ProtonLoginPage(WebDriver driver) {
        super(driver);
        WaitUtils waitUtils = new WaitUtils(driver);
        waitUtils.waitForElementPresence(By.id("password"), 10);

    }

    @Override
    public boolean isOpened() {
        try {
            return submitButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void login(String email, String password) {

        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
