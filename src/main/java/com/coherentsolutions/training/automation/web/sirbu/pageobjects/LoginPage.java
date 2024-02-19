package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage extends BasePage {

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="pass")
    private WebElement passwordFied;

    @FindBy(id="send2")
    private WebElement loginButton;

    @FindBy(className = "authorization-link")
    private WebElement signInLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        try {
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("authorization-link")));

        signInLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        emailField.clear();
        emailField.sendKeys(email);
        passwordFied.clear();
        passwordFied.sendKeys(password);
        loginButton.click();

    }

}
