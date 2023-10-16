package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;


public class DriverManager {
    //here we instantiate the class when is calling
    WebDriverManager webDriverManager;
    public WebDriver setBrowser(BrowsersList browser) throws Exception {
        switch (browser) {
            case CHROME: webDriverManager = setChromeDriver();
            break;
            case EDGE: webDriverManager =setEdgeDriver();
            break;
            case SAFARI:webDriverManager = setSafariDriver();
            break;
            default:
                throw new Exception("Incorrect browser or Unsupported browser");
        };

        return webDriverManager.create();
    }

    private WebDriverManager setSafariDriver() {
        return WebDriverManager.safaridriver();
    }

    private WebDriverManager setChromeDriver() {
        ChromeOptions options = (ChromeOptions) setChromiumOptions(new ChromeOptions());
        webDriverManager = WebDriverManager.chromedriver();

        /* Add setChromeNetworkConditions here, when necessary (testing purposes)*/
        return webDriverManager.capabilities(options);
    }

    private ChromiumOptions<?> setChromiumOptions(ChromiumOptions<?> options) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.SEVERE);

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", "false");

//        options.addArguments("--test-type");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--lang=en-US");

        // Remove 'Chrome is being controlled by automated test software' infobar
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("prefs", prefs);
//        options.addArguments("--no-first-run");
//        options.addArguments("--ignore-certificate-errors");
//        options.setCapability(ACCEPT_INSECURE_CERTS, true);
//        options.setCapability("goog:loggingPrefs", logPrefs);

        return options;
    }


    private WebDriverManager setEdgeDriver() {
        EdgeOptions options = (EdgeOptions) setChromiumOptions(new EdgeOptions());
        webDriverManager = WebDriverManager.edgedriver();
        return webDriverManager.capabilities(options);
    }
}
