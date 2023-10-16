package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenItemsPage extends BasePage{

    @FindBy(xpath = "//div[@id='option-label-size-143-item-170']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-52']")
    private WebElement colorSelect;

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement addToCartButton;

//    @FindBy(className = "product-item")
//    private List<ProductItem> productItems;


    public MenItemsPage(WebDriver driver) {
        super(driver);
    }
}
