package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage{
    @FindBy(xpath = "//span[normalize-space()='Add New Address']")
    private WebElement addNewAddressButton;

    public AddressPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, addNewAddressButton, LOCATOR_TIMEOUT);
    }

    public CreateNewAddressPage clickAddNewAddress(){
        addNewAddressButton.click();
        return new CreateNewAddressPage(driver);
    }
}
