package com.nashtech.demoqa.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;


public class PropertiesFileUtil {
    private static final Logger LOGGER = LogManager.getLogger(PropertiesFileUtil.class);

    private PropertiesFileUtil() {}

    public static Properties loadPropertiesFromFile(String filePath) throws IOException {
        LOGGER.info("Load Properties file {}", filePath);
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        }
    }

    public static void appendSystemProperties(Properties properties) {
        LOGGER.info("Append System Properties from properties file {}", properties);
        for (String name: properties.stringPropertyNames()) {
            String value = properties.getProperty(name); 
            System.setProperty(name, value);
        }
    }
}
