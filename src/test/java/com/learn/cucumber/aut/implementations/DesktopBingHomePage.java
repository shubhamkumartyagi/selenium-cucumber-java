package com.learn.cucumber.aut.implementations;

import com.learn.cucumber.aut.model.BingHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class DesktopBingHomePage implements BingHomePage {

  @Value("${aut.urls.home.bing}")
  private String homePageUrl;

  private final WebDriver driver;

  @Autowired
  public DesktopBingHomePage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public void load() {
    driver.get(homePageUrl);
  }

  @Override
  public void searchFor(String searchTerm) {
    driver.findElement(By.id("sb_form_q")).sendKeys(searchTerm);
    driver.findElement(By.xpath("//*[@id='sb_form_go']/following::label")).click();
  }
}
