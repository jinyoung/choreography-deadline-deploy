package saga.choreography.with.deadline.handling.main;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = { "pretty", "html:target/cucumber" },
    features = "src/test/resources/features",
    extraGlue = "saga.choreography.with.deadline.handling/common"
)
public class TestMain {}
