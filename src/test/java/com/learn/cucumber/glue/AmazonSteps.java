package com.learn.cucumber.glue;

import com.learn.cucumber.aut.model.AmazonHomePage;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class AmazonSteps implements En {

    @Autowired
    private AmazonHomePage amazonHomePage;

    public AmazonSteps() {

        Given("I am on the amazon home page", () -> {
            amazonHomePage.load();
        });

        When("^I enter \"([^\"]*)\" in the search box$", (String searchText) -> {
            amazonHomePage.enterTextInSearchBox(searchText);
        });

        Then("^I click \"([^\"]*)\" button on the page$", (String buttonText) -> {
            amazonHomePage.clickOnButton(buttonText);
        });

        Then("^I click Search button on the page$", () -> {
            amazonHomePage.clickOnSearchButton();
        });

        Then("^The first search result should contain \"([^\"]*)\"$", (String expectedValue) -> {
            String actualValue = ((RemoteWebElement) amazonHomePage.getSearchResultLinks().get(0))
                    .findElementByTagName("span").getText();
            Assert.assertTrue("Search Results does not contains searched item, Value at first option is: " + actualValue, actualValue.contains(expectedValue));
        });

        Then("^I click on accept Cookies Button$", () -> {
            amazonHomePage.acceptCookies();
        });

        And("^I select \"([^\"]*)\"$", (String productName) -> {
            amazonHomePage.clickOnSearchedProduct(productName);
        });

        Then("^The (\\d+) search result should contain \"([^\"]*)\"$", (Integer arg0, String arg1) -> {
            String actualValue = ((RemoteWebElement) amazonHomePage.getSearchResultLinks().get(arg0))
                    .findElementByTagName("span").getText();
            Assert.assertTrue("Search Results does not contains searched item, Value at first option is: " + actualValue, actualValue.contains(arg1));
        });

    }
}
