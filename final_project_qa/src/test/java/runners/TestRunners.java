package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},                           // Steps definition package
        plugin = {
            "pretty",                                   // Pretty console output
            "html:target/cucumber-report.html",          // HTML report
            "json:target/cucumber-report.json",          // JSON report
            "junit:target/cucumber-report.xml"           // JUnit XML report
        },
        strict = true                                  // Fail if there are pending or undefined steps 

)

public class TestRunners {

}
