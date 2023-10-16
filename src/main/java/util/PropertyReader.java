package util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertyReader {
    private final static String path = "src\\main\\resources\\atf.properties";
    private static Properties properties;

    private PropertyReader() {
        try {
            InputStream input = new FileInputStream(path);
            properties=new Properties();
            properties.load(input);
            log.info("Properties were read from atf.properties file");
        } catch (
                IOException e) {
            log.error("No properties file could be found");
        }
    }

    private static Properties getProperties() {
        if (properties == null)
            new PropertyReader();
        return properties;
    }

    public static BrowsersList getBrowserName() {
        String browserName = getProperties().getProperty("browser");
        if (browserName == null) {
            log.info("\"Browser\" key was not identified. \"Chrome\" will be used as default");
            browserName = "Chrome";
        }
        return EnumUtils.getEnumIgnoreCase(BrowsersList.class, browserName);
    }

    public static long getWait() {
        String implicitlyWait = getProperties().getProperty("implicitlyWait");
        long impWait = 0L;
        if (implicitlyWait != null) {
            try {
                impWait = Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                log.error("Not able to parse value : " + implicitlyWait + " into long, default value 0 will be used");
            }
        } else {
            log.error("'implicitlyWait' was not defined, default value 0 will be used");
        }
        if (impWait < 0) {
            log.error("'implicitlyWait' value is negative, default value 0 will be used");
            impWait = 0;
        }
        return impWait;
    }

    public static Boolean getBrowserWindowSize() {
        String windowSize = getProperties().getProperty("windowMaximize");
        if (windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public static String getBaseUrl() {
        String url = getProperties().getProperty("URL");
        if (url != null) return url;
        else
            throw new RuntimeException("Application URL not specified in the atf.properties file for the Key:URL");
    }
}
