package com.coherentsolutions.training.automation.web.sirbu.pageobjects;


import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebElementUtils;
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


public class HomePage extends BasePage {
    private static final int LOCATOR_TIMEOUT = 10;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    private WebElement logo;
    @FindBy(className = "authorization-link")
    private WebElement signInLink;
    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountLink;


    public HomePage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, logo, LOCATOR_TIMEOUT);
    }

    public LoginPage clickSignInLink(){
        signInLink.click();
        return new LoginPage(driver);
    }
    public AccountCreationPage clickCreateAccountLink(){
        createAccountLink.click();
        return new AccountCreationPage(driver);
    }

}
