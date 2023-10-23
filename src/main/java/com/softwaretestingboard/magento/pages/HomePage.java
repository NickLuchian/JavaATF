package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Products;
@Slf4j
@Getter
public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='input-autocomplit']")
    private WebElement searchProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateUrl() {
        Assertions.assertThat(getUrl()).isEqualTo("https://dev.mepart.ru/");
        log.info("user is on home page");
    }

    public void inputArticle(String article){
        searchProduct.sendKeys(article);
        searchProduct.sendKeys(Keys.ENTER);
    }
}
