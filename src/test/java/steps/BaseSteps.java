package steps;

import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.MenItemsPage;
import org.openqa.selenium.WebDriver;
import util.ScenarioContext;

import static util.ContextKeys.DRIVER;

public class BaseSteps {

    public final WebDriver driver = ScenarioContext.retrieve(DRIVER, WebDriver.class);

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public MenItemsPage getMenItemsPage(){
        return new MenItemsPage(driver);
    }
}
