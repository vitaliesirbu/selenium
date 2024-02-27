package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.User;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationPage extends  BasePage{

    private static final int LOCATOR_TIMEOUT = 10;

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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, LOCATOR_TIMEOUT), this);
    }


    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(createAccountButton);
    }

    public void createAccount(User user){

        fillInFirstNameField(user);
        fillInLastNameField(user);
        fillInEmailField(user);
        fillInPasswordField(user);
        fillInConfirmPasswordField(user);

        clickOnConfirmButton();

    }

    public void fillInFirstNameField(User user){
        firstNameField.sendKeys(user.getFirstName());
    }
    public void fillInLastNameField(User user){
        lastNameField.sendKeys(user.getLastName());
    }
    public void fillInEmailField(User user){
        emailField.sendKeys(user.getEmail());
    }
    public void fillInPasswordField(User user){
        passwordField.sendKeys(user.getPassword());
    }
    public void fillInConfirmPasswordField(User user){
        confirmPasswordField.sendKeys(user.getPassword());
    }
    public void clickOnConfirmButton(){
        createAccountButton.click();
    }

    public String actualAccountName(WebElement actual){
        String actualContactName = actual.getText();
        actualContactName = actualContactName.split("\n")[0];
        return actualContactName;

    }

}
