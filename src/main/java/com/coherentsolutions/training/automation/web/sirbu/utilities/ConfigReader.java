package com.coherentsolutions.training.automation.web.sirbu.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private Properties properties;

    private ConfigReader(String configFile) {
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(configFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConfigReader getInstance(String configFile) {
        if (instance == null) {
            instance = new ConfigReader(configFile);
        }
        return instance;
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
    public String getUrl() {
        return getProperty("url");
    }
}


