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
    private static final int LOCATOR_TIMEOUT = 10;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="pass")
    private WebElement passwordField;

    @FindBy(id="send2")
    private WebElement loginButton;

    @FindBy(className = "authorization-link")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountLink;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LOCATOR_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("authorization-link")));

        signInLink.click();
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public void createAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(LOCATOR_TIMEOUT));
        WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")));
        createAccountLink.click();

    }

}
