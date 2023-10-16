package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        plugin = {"pretty", "html:target/report", "json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"hooks",
                "steps"},
        tags = "not @Ignore",
        monochrome = true,
        stepNotifications = true
)
public class RunTest {
}
