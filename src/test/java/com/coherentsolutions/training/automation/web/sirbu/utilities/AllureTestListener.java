package com.coherentsolutions.training.automation.web.sirbu.utilities;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;

public class AllureTestListener implements ITestListener {
    @Attachment(value = "Browser Information", type = "text/plain")
    public String attachBrowserInfo(String browserInfo) {
        return browserInfo;
    }
}