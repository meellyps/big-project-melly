package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage extends BasePage {
    @FindBy(xpath = "//div[@class='GeneralSubNavBar_title__text__3UFWr indiana-scroll-container indiana-scroll-container--hide-scrollbars']/h1")
    WebElement teamPageHeader;
    @FindBy(xpath = "//h1[.='Board']/ancestor::div[@class='BoxMenu_container__1flgD']")
    WebElement boardCard;
    @FindBy(xpath = "//div[@class='OverviewOptionButton_container__M-oKs']")
    WebElement buttonOverview;
    @FindBy(xpath = "//p[.='Board']/ancestor::div[@class='OverviewOptionPopUp_text__1pQoR']")
    WebElement buttonBoard;

    public TeamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TeamPage verifyPage(String expectedText) {
        verifyElementText(teamPageHeader, expectedText);
        return this;
    }

    public BoardPage clickBoardCard() {
        boardCard.click();
        return new BoardPage(driver);
    }

    public TeamPage clickOverviewButton() {
        buttonOverview.click();
        return this;
    }

    public BoardPage clickBoardButton() {
        buttonBoard.click();
        return new BoardPage(driver);
    }
}
