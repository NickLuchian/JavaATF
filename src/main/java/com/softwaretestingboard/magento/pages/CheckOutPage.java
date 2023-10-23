package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Slf4j
@Getter
public class CheckOutPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder=\"Ваше имя *\"]")
    private WebElement nameTextField;

    @FindBy(xpath = "//input[@placeholder=\"Ваш телефон *\"]")
    private WebElement phoneTextField;

    @FindBy(xpath = "//input[@name=\"EMAIL\"]")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@name=\"DELIVERY_ID\" and @value=\"3\"]")
    private WebElement deliveryRadioButton;

    @FindBy(xpath = "//input[@id='PAY_SYSTEM_4']")
    private WebElement paymentTypeRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Оформить заказ')]")
    private WebElement buyButton;


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateUrl() {
        Assertions.assertThat(getUrl()).isEqualTo("https://dev.mepart.ru/");
        log.info("user is on checkout page");
    }

}
