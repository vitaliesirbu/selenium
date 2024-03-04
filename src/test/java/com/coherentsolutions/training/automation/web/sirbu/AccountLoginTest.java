package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.HomePage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.LoginPage;
import com.coherentsolutions.training.automation.web.sirbu.pageobjects.MyAccountPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AccountLoginTest extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    @BeforeClass
    @Override
    @Parameters({"platform", "browserName", "browserVersion"})
    public void setUp(@Optional String platform, @Optional String browserName, @Optional String browserVersion) throws MalformedURLException {
        super.setUp(platform, browserName, browserVersion);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(groups = {"loginGroup"}, description = "This test verifies  account login functionality.")
    @Epic("Authentication")
    @Feature("Login")
    @Story("Valid Login")

    public void testSuccessfulLogin(){

        homePage.clickSignInLink();
        User baseUser = UserFactory.createBaseUser();
        loginPage.login(baseUser);
        myAccountPage.goToMyAccount();

        String actualUsername = myAccountPage.actualAccountName(myAccountPage.contactInformation);
        String expectedUsername = configReader.getProperty("expectedContactName");
        Assert.assertEquals(actualUsername, expectedUsername, "The actual username does not match the expected username.");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
