package com.learn.cucumber.glue;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonSteps implements En {

    @Autowired
    WebDriver webDriver;

    public CommonSteps() {

        After((Scenario scenario) -> {
            if (scenario.isFailed()) {
                byte[] screenshotAs = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotAs, "image/png", scenario.getName());
            }
        });
    }
}
