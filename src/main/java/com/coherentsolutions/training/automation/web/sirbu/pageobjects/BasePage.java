package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected final int LOCATOR_TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, LOCATOR_TIMEOUT), this);
    }

    public abstract boolean isOpened();

}
