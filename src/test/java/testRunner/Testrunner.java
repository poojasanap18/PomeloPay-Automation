package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features"
        ,glue= "stepDef",
plugin = ("html:target/cucumber-reports/CucumberTestReport.html"),
monochrome= true,
dryRun= false)

public class Testrunner extends AbstractTestNGCucumberTests {
    
    }
