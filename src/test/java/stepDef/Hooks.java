package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import utils.CommonUtils;

public class Hooks {
    public static WebDriver driver;
    public static String homePageUrl = "https://staging.cicle.app/companies/61eba2c85080f47b25ddc8f8";
    public static String verifyHomePageText = "Home";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://staging.cicle.app/");
        driver.manage().window().maximize();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjYyZjcxZjZiNTkwOWRiM2IxNDhmMTNmZCIsImdvb2dsZUlkIjoiMTA2OTQ3NTU4NjI2MTI4MjUwMzExIiwiZW1haWwiOiJtZWxseXB1c3BpdGEyMUBnbWFpbC5jb20iLCJmdWxsTmFtZSI6Im1lbGx5IHB1c3BpdGEgc2FyaSIsInBob3RvVXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EtL0FGZFp1Y3JfWnh3ZUg1U0ZaTVFrODM5SXV4QlpnX0taZFhXOFpxeEVUOVIxX1E9czk2LWMiLCJiaW8iOiJUZXN0IEJpb1Rlc3QgQmlvVGVzdCBCaW8iLCJzdGF0dXMiOiJNYW5hZ2VyTWFuYWdlck1hbmFnZXIiLCJkZWZhdWx0Q29tcGFueSI6eyJfaWQiOiI2MzJlNjdiNDNjNmUxMDE3NzI2M2E5ZWEifSwiY3JlYXRlZEF0IjoiMjAyMi0wOC0xM1QwMzo1MDowMy43MTdaIiwidXBkYXRlZEF0IjoiMjAyMi0wOS0yNFQwMjoxMzowOC42NDlaIiwiX192IjowfSwiaWF0IjoxNjYzOTg2MDM2LCJleHAiOjE2NjY1NzgwMzZ9.6-KQvPoLtTau_pyZS4ePkRe5UpSDv5kvpmy9EghsbVY";
        CommonUtils.setToken(driver, token);
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

    @When("user navigate to team page")
    public void userNavigateToTeamPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTeamCard();
    }
}
