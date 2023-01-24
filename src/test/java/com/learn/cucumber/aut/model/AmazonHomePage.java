package com.learn.cucumber.aut.model;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface AmazonHomePage {

    void load();

    void enterTextInSearchBox(String text);

    void clickOnButton(String buttonText);

    void clickOnSearchButton();

    void acceptCookies();

    List<WebElement> getSearchResultLinks();

    void clickOnSearchedProduct(String productName);
}
