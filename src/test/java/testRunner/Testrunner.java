package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDef", plugin = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json" }, monochrome = true, dryRun = false)

public class Testrunner extends AbstractTestNGCucumberTests {

}
