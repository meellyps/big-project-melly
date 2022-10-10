package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import utils.SendEmail;

public class runner {

    @CucumberOptions(
            features = "src/test/resources/feature",
            glue= {"stepDef"},
            plugin = {"pretty", "html:target/cucumber-report.html"},
            tags = "@board_001 or @board_002"
    )
    public static class run extends AbstractTestNGCucumberTests {
        @AfterSuite
        public void sendReportEmail() {
            String[] args = new String[] {
                    "mellypuspita21@gmail.com",
                    "de.boyz99@gmail.com",
                    "Big Project Report - Melly",
                    "Big Project Report",
                    "D:\\adiladios\\project\\java\\big-project-melly\\target\\cucumber-report.html"
            };
            SendEmail.main(args);
        }
    }
}
