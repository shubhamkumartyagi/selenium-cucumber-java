package com.learn.cucumber.aut.implementations;

import com.learn.cucumber.aut.model.BingSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class DesktopBingSearchResultsPage implements BingSearchResultsPage {
  private final WebDriver driver;

  @Autowired
  public DesktopBingSearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public String getFirstResultTitle() {
    return driver.findElement(By.cssSelector("ol#b_results > li > h2 > a")).getText();
  }
}
