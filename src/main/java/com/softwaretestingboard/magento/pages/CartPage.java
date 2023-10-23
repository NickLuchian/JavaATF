package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Slf4j
@Getter
public class CartPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Оформить заказ')]")
    private WebElement proceedToBuy;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateUrl() {
        Assertions.assertThat(getUrl()).isEqualTo("https://dev.mepart.ru/personal/cart/");
        log.info("user is on cart page");
    }


}
