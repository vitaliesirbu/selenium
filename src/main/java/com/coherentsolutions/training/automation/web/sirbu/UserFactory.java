package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;

public class UserFactory {
    private static final ConfigReader configReader = ConfigReader.getInstance("config.properties");

    public static User createBaseUser() {
        String firstName = configReader.getProperty("newFirstName");
        String lastName = configReader.getProperty("newLastName");
        String email = configReader.getProperty("newEmail");
        String password = configReader.getProperty("newPassword");


        String streetLine1 = configReader.getProperty("streetLine1");
        String streetLine2 = configReader.getProperty("streetLine2");
        String streetLine3 = configReader.getProperty("streetLine3");
        String city = configReader.getProperty("city");
        String province = configReader.getProperty("province");
        String postalCode = configReader.getProperty("postalCode");
        String country = configReader.getProperty("country");
        String phoneNumber = configReader.getProperty("phoneNumber");


        Address address = new Address(streetLine1, streetLine2, streetLine3, city, province, postalCode, country, phoneNumber);

        if (firstName == null || lastName == null || email == null || password == null) {
            throw new IllegalStateException("One of the user properties is null. Please check config.properties file.");
        }

        return new User(firstName, lastName, email, password, address);
    }
}
