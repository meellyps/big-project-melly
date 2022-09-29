package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.TeamPage;
import utils.CommonUtils;

public class Hooks {
    public static WebDriver driver;
    public static String homePageUrl = "https://staging.cicle.app/companies/61eba2c85080f47b25ddc8f8";
    public static String verifyHomePageText = "Home";
    public static String verifyTeamPageText = "QA-14-BP-B";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://staging.cicle.app/");
        driver.manage().window().maximize();
        CommonUtils.getToken(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage(homePageUrl).verifyPage(verifyHomePageText);
    }

    @When("user click team card")
    public void userClickTeamCard() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTeamCard();
    }

    @Then("user should be navigated to team page")
    public void userShouldBeNavigatedToTeamPage() throws InterruptedException {
        TeamPage teamPage = new TeamPage(driver);
        Thread.sleep(1000);
        teamPage.verifyPage(verifyTeamPageText);
    }
}
