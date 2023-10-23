package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Products;
@Getter
public class ProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='search_fon new-table search-table position-relative']")
    private WebElement productsTable;

    @FindBy(xpath = "//button[@id='basket-add-popup-submit']")
    private WebElement bascketAddPopup;

    @FindBy(xpath = "//a[@href='/personal/cart/']")
    private WebElement bascketLogoButton;

    @FindBy(xpath = "//div[@id='arProduct']")
    private WebElement table1;

    @FindBy(xpath = "//div[@class='search_fon_head']")
    private WebElement infoHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateUrl() {
        Assertions.assertThat(getUrl()).isEqualTo("https://dev.mepart.ru/product/a113707110ca-CHERY");
        System.out.println(getTitle());
    }

    public WebElement selects(Products element){
        return productsTable.findElement(By.partialLinkText(element.getTitle()));
    };

    public WebElement clickableElement(Products element){
        return productsTable.findElement(By.xpath(String.format("//div[@id='arProduct']/div[@data-name='%s']/div[@class='col-cart mt-2 mt-lg-0']/a[@href='#']", element.getTitle())));
    }

    public void clickAddToCart(){
        bascketAddPopup.click();
    }

}
