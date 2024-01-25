package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DownloadPage extends BasePage{

    @FindBy(xpath="//a[normalize-space()='demo.txt']")
    private WebElement downloadButton;

    public DownloadPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened(){
        try {
            return downloadButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void downloadFile(){
        downloadButton.click();
    }
    public String getDownloadFileHref(){
        return downloadButton.getAttribute("href");
    }
}
