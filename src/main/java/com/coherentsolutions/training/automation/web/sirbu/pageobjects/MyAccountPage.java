package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage{
    private static final int LOCATOR_TIMEOUT = 10;
    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    private WebElement goToMyAccountButton;
    @FindBy(xpath = "//a[normalize-space()='Address Book']")
    private WebElement addressPagelink;

    @FindBy(css=".box-content p")
    public WebElement contactInformation;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, contactInformation, LOCATOR_TIMEOUT);
    }

    public String actualAccountName(WebElement actual){

        String actualContactName = actual.getText();
        actualContactName = actualContactName.split("\n")[0];
        return actualContactName;

    }
    public String goToMyAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        goToMyAccountButton.click();
        return "My Account";
    }
    public AddressPage goToAddressPage(){
        addressPagelink.click();
        return new AddressPage(driver);
    }
}
