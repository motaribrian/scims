package com.codewithmotari.scims.config;

import java.io.InputStream;
import java.util.Properties;

public class DatasourceConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatasourceConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("Could not load app.properties from classpath.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getOrDefault(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
