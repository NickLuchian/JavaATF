package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import util.*;

import static util.ContextKeys.DRIVER;

public class Hooks {

    WebDriver driver;

    @Before
    public  void startingBrowser() throws Exception {
        DriverManager driverManager = new DriverManager();
        BrowsersList browser = PropertyReader.getBrowserName();
        driver = driverManager.setBrowser(browser);
        driver.manage().window().maximize();
        driver.get(PropertyReader.getBaseUrl());
        ScenarioContext.save(DRIVER, driver);
    }

    @After
    public void after () {
        driver.quit();
        System.out.println("test finished");
    }

}
