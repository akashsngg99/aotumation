package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Path to your feature files
        glue = "stepdefinitions",      // Path to your step definition files
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,             // Readable console output
        snippets = CucumberOptions.SnippetType.CAMELCASE, // Generates step definition snippets in camel case
        dryRun = false                 // Set to true to check if all steps have step definitions
)
public class TestRunner {
    // This class will run all the features found in the 'features' path
    // and use the step definitions from the 'glue' path.
}