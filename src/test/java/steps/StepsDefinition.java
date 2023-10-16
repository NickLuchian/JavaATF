package steps;

import com.softwaretestingboard.magento.pages.HomePage;

import io.cucumber.java.en.Given;

import org.junit.Assert;

public class StepsDefinition extends BaseSteps {
    @Given("start browser")
    public void startBrowser() {
        System.out.println("test");
        HomePage homePage = getHomePage();
        String phoneText = homePage.getLogo().getText();
        Assert.assertEquals("phone number is displayed", phoneText, "+7 (800) 301-30-88");
    }

//    @Given("{string} page is displayed")
//    public void homePageIsDisplayed() {
//    }
//
//    @When("User clicks on {string} category button")
//    public void userClicksOnMenCategoryButton() {
//    }
//
//    @And("{string} category page is displayed")
//    public void menCategoryPageIsDisplayed() {
//    }
//
//    @And("User selects {string} item")
//    public void userSelectsFirstItem() {
//    }
//
//    @Then("User is on {string} page")
//    public void userIsOnItemPage() {
//    }
//
//    @And("User selects {string}")
//    public void userSelectsSize() {
//    }
//
//    @And("User clicks on {string} button")
//    public void userClicksOnAddToCartButton() {
//    }
//
//    @Then("Message with {string} name is displayed")
//    public void messageWithItemNameIsDisplayed() {
//    }
}
