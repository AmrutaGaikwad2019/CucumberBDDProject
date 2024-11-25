import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/login.feature", glue= {"StepDefinition"},
monochrome = true,
plugin= {"pretty","html:target/reports/cucumber.html", "junit:target/reports/cucumber.xml", "json:target/reports/cucumber.json"},
tags="@must")
public class TestRunner {

}
