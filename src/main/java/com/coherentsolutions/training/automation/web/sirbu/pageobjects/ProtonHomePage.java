package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProtonHomePage extends BasePage{

    @FindBy(xpath="//h2[@title='Inbox']")
    private WebElement loggedInLocator;

    @Override
    public boolean isOpened() {
         return WebElementUtils.isElementDisplayed(loggedInLocator);
    }

    public ProtonHomePage(WebDriver driver) {
        super(driver);
    }


}

