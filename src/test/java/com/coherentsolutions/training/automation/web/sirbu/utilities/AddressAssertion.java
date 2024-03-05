package com.coherentsolutions.training.automation.web.sirbu.utilities;

import org.testng.Assert;

public class AddressAssertion {
    public static void assertBillingAddress(String expectedAddress, String actualAddress) {
        Assert.assertEquals(actualAddress, expectedAddress, "Billing addresses do not match");
    }


    public static void assertBillingAddressFields(String expectedName, String actualName,
                                                  String expectedLine1, String actualLine1,
                                                  String expectedLine2, String actualLine2,
                                                  String expectedLine3, String actualLine3,
                                                  String expectedCity, String actualCity) {
        Assert.assertEquals(actualName, expectedName, "Name does not match");
        Assert.assertEquals(actualLine1, expectedLine1, "Line 1 does not match");
        Assert.assertEquals(actualLine2, expectedLine2, "Line 2 does not match");
        Assert.assertEquals(actualLine3, expectedLine3, "Line 3 does not match");
        Assert.assertEquals(actualCity, expectedCity, "City does not match");

    }
}

