package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class runner {

    @CucumberOptions(
            features = "src/test/resources/feature",
            glue= {"stepDef"},
            plugin = {"pretty", "html:target/cucumber-report.html"},
            tags = "@board_001"
    )
    public static class run extends AbstractTestNGCucumberTests {}
}
