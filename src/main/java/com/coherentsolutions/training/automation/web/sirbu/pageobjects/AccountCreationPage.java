package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationPage extends  BasePage{

    @FindBy(id="firstname")
    private WebElement firstNameField;
    @FindBy(id="lastname")
    private WebElement lastNameField;

    @FindBy(id="email_address")
    private WebElement emailField;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="password-confirmation")
    private WebElement confirmPasswordField;
    @FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    private WebElement createAccountButton;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return ElementUtils.isOpened(createAccountButton);
    }

    public void createAccount(String firstName,String lastName, String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);

        createAccountButton.click();
    }

    public String actualAccounName(WebElement actual){
        String actualContactName = actual.getText();
        actualContactName = actualContactName.split("\n")[0];
        return actualContactName;

    }

}
