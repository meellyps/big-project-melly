package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage extends BasePage {
    @FindBy(xpath = "//h1[.='Board']/ancestor::div[@class='BoxMenu_container__1flgD']")
    WebElement boardCard;
    @FindBy(xpath = "//div[@class='OverviewOptionButton_container__M-oKs']")
    WebElement overviewButton;
    @FindBy(xpath = "//p[.='Board']/ancestor::div[@class='OverviewOptionPopUp_text__1pQoR']")
    WebElement boardButton;
    @FindBy(xpath = "//h1[.='Group Chat']/ancestor::div[@class='BoxMenu_container__1flgD']")
    WebElement groupChatCard;
    @FindBy(xpath = "//p[.='Group Chat']/ancestor::div[@class='OverviewOptionPopUp_text__1pQoR']")
    WebElement groupChatButton;
    @FindBy(xpath = "//h1[.='Schedule']/ancestor::div[@class='BoxMenu_container__1flgD']")
    WebElement scheduleCard;
    @FindBy(xpath = "//h1[.='Schedule']/ancestor::div[@class='BoxMenu_container__1flgD']")
    WebElement scheduleButton;

    public TeamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TeamPage verifyPage() {
        verifyElementPresent(boardCard);
        return this;
    }

    public BoardPage clickBoardCard() {
        boardCard.click();
        return new BoardPage(driver);
    }

    public TeamPage clickOverviewButton() {
        overviewButton.click();
        return this;
    }

    public BoardPage clickBoardButton() {
        boardButton.click();
        return new BoardPage(driver);
    }

    public GroupChatPage clickGroupChatCard() {
        groupChatCard.click();
        return new GroupChatPage(driver);
    }

    public GroupChatPage clickGroupChatButton() {
        groupChatButton.click();
        return new GroupChatPage(driver);
    }

    public SchedulePage clickScheduleCard() {
        scheduleCard.click();
        return new SchedulePage(driver);
    }
    public SchedulePage clickScheduleButton() {
        scheduleButton.click();
        return new SchedulePage(driver);
    }
}
