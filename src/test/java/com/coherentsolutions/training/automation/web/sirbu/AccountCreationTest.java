package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.AccountCreationPage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.MyAccountPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class AccountCreationTest extends BaseTest{

    private HomePage homePage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");
    private String expectedContactName = configReader.getProperty("expectedContactName");


    @BeforeClass
    @Override
    @Parameters({"platform", "browserName", "browserVersion"})
    public void setUp(@Optional String platform, @Optional String browserName, @Optional String browserVersion) throws MalformedURLException {
        super.setUp(platform, browserName, browserVersion);
        homePage = new HomePage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage =new MyAccountPage(driver);
    }

    @Test(groups = {"loginGroup"}, description = "This test verifies new account registration functionality.")
    @Epic("Authentication")
    @Feature("Registration")
    @Story("Valid Registration")

    public void testSuccessfulRegistration() {
        homePage.clickCreateAccountLink();

        User baseUser = UserFactory.createBaseUser();

        accountCreationPage.createAccount(baseUser);

        String actualContactName = myAccountPage.getContactInformation();

        Assert.assertEquals(actualContactName, expectedContactName, "The contact name does not match the expected value.");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
