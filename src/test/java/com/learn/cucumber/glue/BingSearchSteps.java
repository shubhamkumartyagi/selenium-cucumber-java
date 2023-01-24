package com.learn.cucumber.glue;

import com.learn.cucumber.aut.model.BingHomePage;
import com.learn.cucumber.aut.model.BingSearchResultsPage;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BingSearchSteps implements En {

    @Autowired
    private BingHomePage bingHomePage;

    @Autowired
    private BingSearchResultsPage bingSearchResultsPage;

    public BingSearchSteps() {

        Given("I am on the bing search engine", () -> {
            bingHomePage.load();
        });

        When("I enter a search term", () -> {
            bingHomePage.searchFor("cucumber");
        });

        Then("relevant results for that search term are displayed", () -> {
            assertThat(bingSearchResultsPage.getFirstResultTitle()).contains("iPhone 12");
        });
    }
}
