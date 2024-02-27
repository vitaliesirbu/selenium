package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
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
        return ElementUtils.isElementDisplayed(contactInformation);
    }
}
