package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.ProtonLoginPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotTest extends BaseTest{

    private ProtonLoginPage loginPage;

    private String username = ConfigReader.getInstance().getUsername();
    private String password = ConfigReader.getInstance().getPassword();

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage = initPage(ProtonLoginPage.class);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login(username, password);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
