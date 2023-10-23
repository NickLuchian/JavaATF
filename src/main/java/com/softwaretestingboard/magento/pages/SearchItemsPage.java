package com.softwaretestingboard.magento.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Products;
@Slf4j
@Getter
public class SearchItemsPage extends BasePage{

    @FindBy(xpath = "//div[@class='row flex-nowrap main-filter-wrapper']")
    private WebElement searchResult;

    public SearchItemsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void validateUrl() {
        Assertions.assertThat(getUrl()).isEqualTo("https://dev.mepart.ru/search/?q=a113707110ca&b=");
        log.info("user is on search items page");
    }

    public WebElement selects(Products element){
        return searchResult.findElement(By.partialLinkText(element.getManufacturer()));
    };

    public void clickElement(Products element){
        searchResult.findElement(By.xpath(String.format("//a[@href=\"/product/%s-%s\"]", element.getArticle(), element.getManufacturer()))).click();
    }
}
