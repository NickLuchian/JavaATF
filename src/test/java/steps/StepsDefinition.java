package steps;

import com.softwaretestingboard.magento.pages.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.*;

import static util.ContextKeys.DRIVER;
import static util.ContextKeys.PRODUCT;

public class StepsDefinition extends BaseSteps {
    HomePage homePage = getHomePage();
    @Given("user is on {pages} page")
    public void userIsOnPage(Pages page) throws InterruptedException {
        getPage(page).validateUrl();
    }


    @When("user searches for article {string}")
    public void userSearchesForArticle(String article) throws Exception {
        homePage.inputArticle(article);
        ScenarioContext.save(ContextKeys.PRODUCT, Products.getProductByArticle(article));
    }


    @When("user checks that article is displayed on the page")
    public void userChecksThatArticleACaIsDisplayedOnThePage() throws Exception {
        getSearchItemsPage().selects(ScenarioContext.retrieve(PRODUCT, Products.class));
        Assertions.assertThat(getSearchItemsPage().selects(Products.PRODUCT1)).isNotNull();
    }

    @Then("user click on chosen article")
    public void userClickOnChosenArticle() {
        getSearchItemsPage().clickElement(Products.PRODUCT1);
    }

    @Then("user clicks on article")
    public void userClicksOnArticle() throws InterruptedException {
        Assertions.assertThat(getProductPage().selects(Products.PRODUCT1)).isNotNull();
        JavascriptExecutor js = (JavascriptExecutor) ScenarioContext.retrieve(DRIVER, WebDriver.class);
        WebElement cartIcon = getProductPage().clickableElement(Products.PRODUCT1);
        js.executeScript("arguments[0].scrollIntoView();", getProductPage().getTable1());
        js.executeScript("arguments[0].style.display = 'none'",getProductPage().getInfoHeader());
        cartIcon.click();
        Thread.sleep(5000);
    }


    @Then("user add article to the cart")
    public void userAddArticleToTheCart() throws InterruptedException {
        getProductPage().clickAddToCart();
        Thread.sleep(5000);
    }

    @Then("user proceed to cart page")
    public void userProceedToCartPage() {
        getProductPage().getBascketLogoButton().click();
    }


    @Then("user proceed to checkout page")
    public void userProceedToCheckoutPage() {
        getCartPage().getProceedToBuy().click();
    }


    @Then("user enters info in the fields")
    public void userEntersInfoInTheFields() throws InterruptedException {

        getCheckOutPage().getNameTextField().sendKeys(Randomizer.randomName());
        getCheckOutPage().getEmailTextField().sendKeys(Randomizer.randomEmail());
        getCheckOutPage().getPhoneTextField().click();
        Thread.sleep(3000);
        getCheckOutPage().getPhoneTextField().sendKeys(Randomizer.randomPhone());
        Thread.sleep(3000);
    }

    @Then("user selects payment method and delivery")
    public void userSelectsPaymentMethodAndDelivery() {
        getCheckOutPage().getDeliveryRadioButton().click();
        getCheckOutPage().getPaymentTypeRadioButton().click();
    }


    @Then("user buys the article")
    public void userBuysTheArticle() {
        getCheckOutPage().getBuyButton().click();
    }
}
