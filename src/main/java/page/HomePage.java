package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='DashboardPage_DashboardPage__flex__2rA7e']//a[@class='LinkNoDecor_Link__3DEkL']")
    WebElement teamCard;
    @FindBy(xpath = "//div[@class='HomeSubNavHeader_title__text__3ITET']/h1")
    WebElement homePageHeader;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage goToHomePage(String url) {
        driver.get(url);
        return this;
    }

    public HomePage verifyPage(String expectedText) {
        verifyElementText(homePageHeader, expectedText);
        return this;
    }

    public TeamPage clickTeamCard() {
        teamCard.click();
        return new TeamPage(driver);
    }
}
