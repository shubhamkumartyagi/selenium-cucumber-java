package com.learn.cucumber.aut.implementations;

import com.learn.cucumber.aut.model.AmazonHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesktopAmazonHomePage implements AmazonHomePage {

    @Value("${aut.urls.home.amazon}")
    private String homePageUrl;

    private final WebDriver driver;

    @Autowired
    public DesktopAmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void load() {
        driver.get(homePageUrl);
    }

    @Override
    public void enterTextInSearchBox(String text) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
    }

    @Override
    public void clickOnButton(String buttonText) {
        driver.findElement(By.xpath("(//span|//button|//a|//input)[text()='" + buttonText + "']")).click();
    }

    @Override
    public void clickOnSearchButton() {
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Override
    public void acceptCookies() {
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @Override
    public List<WebElement> getSearchResultLinks() {
        return driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
    }

    @Override
    public void clickOnSearchedProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }
}
