package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;

public class UserFactory {
    private static final ConfigReader configReader = ConfigReader.getInstance("config.properties");

    public static User createBaseUser() {
        String firstName = configReader.getProperty("newFirstName");
        String lastName = configReader.getProperty("newLastName");
        String email = configReader.getProperty("newEmail");
        String password = configReader.getProperty("newPassword");

        if (firstName == null || lastName == null || email == null || password == null) {
            throw new IllegalStateException("One of the user properties is null. Please check config.properties file.");
        }

        return new User(firstName, lastName, email, password);
    }
}
