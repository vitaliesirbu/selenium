package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.User;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
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
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, signInButton, LOCATOR_TIMEOUT);
    }


    public LoginPage login(User user) {

        fillInEmailField(user);
        fillInPasswordField(user);

        clickOnSignInButton();

        return new LoginPage(driver);

    }

    public LoginPage fillInEmailField(User user){emailField.sendKeys(user.getEmail());return this;}
    public LoginPage fillInPasswordField(User user){passwordField.sendKeys(user.getPassword());return this;}
    public HomePage clickOnSignInButton(){signInButton.click();return new HomePage(driver);}


}
