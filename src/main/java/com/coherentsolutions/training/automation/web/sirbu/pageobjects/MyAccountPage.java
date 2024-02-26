package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(css=".box-content p")
    private WebElement contactInformation;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        try {
            return contactInformation.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
