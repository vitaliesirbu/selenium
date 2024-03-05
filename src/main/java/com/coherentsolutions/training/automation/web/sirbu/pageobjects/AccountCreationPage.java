package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.User;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
    @CacheLookup
    private WebElement createAccountButton;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, createAccountButton, LOCATOR_TIMEOUT);
    }

    public MyAccountPage createAccount(User user){

        fillInFirstNameField(user);
        fillInLastNameField(user);
        fillInEmailField(user);
        fillInPasswordField(user);
        fillInConfirmPasswordField(user);

        clickOnConfirmButton();
        return new MyAccountPage(driver);

    }

    public AccountCreationPage fillInFirstNameField(User user) {
        firstNameField.sendKeys(user.getFirstName());
        return this;
    }
    public AccountCreationPage fillInLastNameField(User user) {
        lastNameField.sendKeys(user.getLastName());
        return this;
    }
    public AccountCreationPage fillInEmailField(User user) {
        emailField.sendKeys(user.getEmail());
        return this;
    }
    public AccountCreationPage fillInPasswordField(User user) {
        passwordField.sendKeys(user.getPassword());
        return this;
    }
    public AccountCreationPage fillInConfirmPasswordField(User user) {
        confirmPasswordField.sendKeys(user.getPassword());
        return this;
    }
    public MyAccountPage clickOnConfirmButton() {
        createAccountButton.click();
        return new MyAccountPage(driver);
    }

    public String getAccountName(WebElement actual){
        String actualContactName = actual.getText();
        actualContactName = actualContactName.split("\n")[0];
        return actualContactName;
    }
}
