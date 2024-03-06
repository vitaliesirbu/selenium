package com.coherentsolutions.training.automation.web.sirbu.pageobjects;

import com.coherentsolutions.training.automation.web.sirbu.User;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAddressPage extends BasePage{
    @FindBy(xpath = "//span[normalize-space()='Save Address']")
    private WebElement saveAddressButton;
    @FindBy(xpath = "//input[@id='street_1']")
    private WebElement streetLine1Field;
    @FindBy(xpath = "//input[@id='street_2']")
    private WebElement streetLine2Field;
    @FindBy(xpath = "//input[@id='street_3']")
    private WebElement streetLine3Field;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    @FindBy(xpath = "//select[@id='region_id']")
    private WebElement stateAndProvinceSelectField;
    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zipAndPostalCodeField;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countrySelectField;
    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='primary_billing']")
    private WebElement defaultBillingAddressCheckBox;
    @FindBy(xpath = "//input[@id='primary_shipping']")
    private WebElement defaultShippingAddressCheckBox;

    public CreateNewAddressPage(WebDriver driver) {super(driver);}

    @Override
    public boolean isOpened() {
        return ElementUtils.isElementDisplayed(driver, saveAddressButton, LOCATOR_TIMEOUT);
    }
    public AddressPage addNewAddress(User user){
        fillInStreetAddressField1(user);
        fillInStreetAddressField2(user);
        fillInStreetAddressField3(user);
        fillInCityField(user);
        fillInCountryField(user);
        fillInPhoneField(user);
        fillInStateField(user);
        fillInZipField(user);
        clickOnSaveAddressButton();
        return new AddressPage(driver);
    }

    public AddressPage clickOnSaveAddressButton(){
        saveAddressButton.click();
        return new AddressPage(driver);
    }
    public CreateNewAddressPage fillInStreetAddressField1(User user){
       streetLine1Field.sendKeys(user.getAddress().getStreetLine1());
        return this;
   }
    public CreateNewAddressPage fillInStreetAddressField2(User user){
        streetLine2Field.sendKeys(user.getAddress().getStreetLine2());
        return this;
    }
    public CreateNewAddressPage fillInStreetAddressField3(User user){
        streetLine3Field.sendKeys(user.getAddress().getStreetLine3());
        return this;
    }
    public CreateNewAddressPage fillInCityField(User user){
        cityField.sendKeys(user.getAddress().getCity());
        return this;
    }
    public CreateNewAddressPage fillInStateField(User user){
        Select dropdown = new Select(stateAndProvinceSelectField);
        dropdown.selectByValue(user.getAddress().getProvince());
        return this;
    }
    public CreateNewAddressPage fillInZipField(User user){
        zipAndPostalCodeField.sendKeys(user.getAddress().getPostalCode());
        return this;
    }
    public CreateNewAddressPage fillInCountryField(User user){
        Select dropdown = new Select(countrySelectField);
        dropdown.selectByValue(user.getAddress().getCountry());
        return this;
    }
    public CreateNewAddressPage fillInPhoneField(User user){
        phoneNumberField.sendKeys(user.getAddress().getPhoneNumber());
        return this;
    }
    public CreateNewAddressPage selectBillingCheckbox(){
        defaultBillingAddressCheckBox.click();
        return this;
    }
    public CreateNewAddressPage selectShippingCheckbox(){
        defaultShippingAddressCheckBox.click();
        return this;
    }
}
