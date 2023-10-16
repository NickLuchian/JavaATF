package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class = 'museo phone d-flex align-items-center justify-content-start']")
    private WebElement Logo;

    @FindBy(xpath = "//input[@id='input-autocomplit']")
    private WebElement searchProduct;

    @FindBy(xpath = "//body/main[1]/div[1]/div[2]/div[1]/div[3]/a[1]")
    private WebElement selectedItem;

    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/h1[1]")
    private WebElement itemName;

    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[5]/div[1]/div[8]/a[1]/img[1]")
    private WebElement addItemToCart;

    @FindBy(xpath = "//button[@id='basket-add-popup-submit']")
    private WebElement bascketAddPopup;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void clickCategory(){
        searchProduct.sendKeys();
    }

    private void clickCartButton(){
        selectedItem.click();
    }

    private void clickProceedToCartButton(){
        addItemToCart.click();
    }

    private void clickAddToBasketPopup(){
        bascketAddPopup.click();
    }
}
