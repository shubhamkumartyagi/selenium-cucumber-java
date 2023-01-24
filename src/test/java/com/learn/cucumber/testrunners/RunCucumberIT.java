package com.learn.cucumber.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        glue = {"com.learn.cucumber"})
public class RunCucumberIT {
}
