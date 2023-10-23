package steps;

import com.softwaretestingboard.magento.pages.*;
import org.openqa.selenium.WebDriver;
import util.Pages;
import util.ScenarioContext;

import static util.ContextKeys.DRIVER;

public class BaseSteps {

    public final WebDriver driver = ScenarioContext.retrieve(DRIVER, WebDriver.class);

    public SearchItemsPage getSearchItemsPage(){
        return new SearchItemsPage(driver);
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }

    public CartPage getCartPage(){return new CartPage(driver);}

    public CheckOutPage getCheckOutPage(){return new CheckOutPage(driver);}

    protected BasePage getPage(Pages page){
        switch (page){
            case HOME: return getHomePage();

            case SEARCH_ITEMS: return getSearchItemsPage();

            case CART: return getCartPage();

            case PRODUCT: return getProductPage();

            case CHECKOUT: return getCheckOutPage();

        }
        return null;
    }
}
