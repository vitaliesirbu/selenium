package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.*;
import com.coherentsolutions.training.automation.web.sirbu.utilities.AddressAssertion;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AddNewAddressTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private AddressPage adressPage;
    private CreateNewAddressPage createNewAddressPage;
    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    @BeforeClass
    @Override
    @Parameters({"platform", "browserName", "browserVersion"})
    public void setUp(@Optional String platform, @Optional String browserName, @Optional String browserVersion) throws MalformedURLException {
        super.setUp(platform, browserName, browserVersion);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        adressPage = new AddressPage(driver);
        createNewAddressPage = new CreateNewAddressPage(driver);

    }

    @Test(groups = {"addressGroup"}, description = "This test verifies  adding new address functionality.")
    @Epic("User Settings")
    @Feature("Adress")
    @Story("Creating new address")
    public void testAddNewAddress(){
        homePage.clickSignInLink();
        User baseUser = UserFactory.createBaseUser();
        loginPage.login(baseUser);
        myAccountPage.goToMyAccount();
        myAccountPage.goToAddressPage();
        adressPage.clickAddNewAddress();
        createNewAddressPage.addNewAddress(baseUser);
        myAccountPage.goToMyAccount();

        String actualBillingAddress = myAccountPage.getBillingAddress();
        String[] actualAddressLines = actualBillingAddress.split("\n");


        String expectedBillingAddressName = configReader.getProperty("billing.address.name");
        String expectedBillingAddressLine1 = configReader.getProperty("billing.address.line1");
        String expectedBillingAddressLine2 = configReader.getProperty("billing.address.line2");
        String expectedBillingAddressLine3 = configReader.getProperty("billing.address.line3");
        String expectedBillingAddressCity = configReader.getProperty("billing.address.city");

        AddressAssertion.assertBillingAddressFields(expectedBillingAddressName, actualAddressLines[0].trim(),
                expectedBillingAddressLine1, actualAddressLines[1].trim(),
                expectedBillingAddressLine2,actualAddressLines[2].trim(),
                expectedBillingAddressLine3, actualAddressLines[3].trim(),
                expectedBillingAddressCity, actualAddressLines[4].trim());
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
