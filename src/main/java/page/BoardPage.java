package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardPage extends BasePage {
    @FindBy(xpath = "//div[@class='CreateListButton_buttonBottom__16OpZ']/ancestor::button")
    WebElement addListButton;
    @FindBy(xpath = "//input[@name='name']")
    WebElement inputListName;
    @FindBy(xpath = "//div[@class='Button_container__1WNuB']")
    WebElement createButton;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[last() - 1]//div[@class='ListContainer_headerSection__title__text__36H_r']/h1")
    WebElement listName;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//div[@class='ListContainer_headerSection__more__3On04']")
    WebElement listActionMenuButton;
    @FindBy(xpath = "//div[@class='ListMenu_headerSection__JaHkO']")
    WebElement listActionHeader;
    @FindBy(xpath = "//div[@class='ListMenu_bodySection__1jhZS']//div[@class='OverlayButton_box__2jFLd']/div[3]")
    WebElement setCompleteListMenu;
    @FindBy(xpath = "//div[@class='ListContainer_headerSection__title__completeIcon__2MbRJ']")
    WebElement checkListCompleted;
    By checkListCompletedLocator =  By.xpath("//div[@class='ListContainer_headerSection__title__completeIcon__2MbRJ']");
    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    WebElement snackBarNotif;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//div[@class='ListContainer_ListContainer__buttonBottom__2kZAI']")
    WebElement addCardButton;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//input[@class='form-control']")
    WebElement inputCardName;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//span[@class='MuiSwitch-root MuiSwitch-sizeSmall css-vd1cxy']")
    WebElement privateCardToggle;
    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    WebElement submitAddCardButton;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//div[@id='listcard_container-0']/div//div[@class='OverlayButton_container__3kxDV'][1]//h1")
    WebElement cardName;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//div[@id='listcard_container-0']/div//div[@class='OverlayButton_container__3kxDV'][1]//h1/*[name()='svg']")
    WebElement lockIcon;
    @FindBy(xpath = "//div[@class='ListMenu_bodySection__1jhZS']//div[@class='OverlayButton_box__2jFLd']/div[2]")
    WebElement archiveListMenu;

    public BoardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BoardPage verifyPage() {
        verifyElementPresent(addListButton);
        return this;
    }

    public BoardPage clickAddListButton() {
        addListButton.click();
        return this;
    }

    public BoardPage inputListName(String text) {
        writeText(inputListName, text);
        return this;
    }

    public BoardPage clickCreateButton() {
        click(createButton);
        return this;
    }

    public BoardPage verifyListNameText(String expectedText) {
        verifyElementText(listName, expectedText);
        return this;
    }

    public BoardPage clickListActionMenuButton() {
        click(listActionMenuButton);
        return this;
    }

    public BoardPage verifyListActionHeader(String expectedText) {
        verifyElementText(listActionHeader, expectedText);
        return this;
    }

    public BoardPage clickSetCompleteMenu() {
        click(setCompleteListMenu);
        return this;
    }

    public BoardPage verifyListCompleted() {
        verifyElementPresent(checkListCompleted);
        return this;
    }

    public BoardPage verifySnackBarNotif(String expectedText) {
        verifyElementText(snackBarNotif, expectedText);
        return this;
    }

    public BoardPage verifyListIncomplete() {
        isNotElementPresent(checkListCompletedLocator);
        return this;
    }

    public BoardPage clickAddCard() {
        click(addCardButton);
        return this;
    }

    public BoardPage inputCardName(String text) {
        writeText(inputCardName, text);
        return this;
    }

    public BoardPage clickPrivateCard() {
        click(privateCardToggle);
        return this;
    }

    public BoardPage clickSubmitAddCardButton() {
        click(submitAddCardButton);
        return this;
    }

    public BoardPage verifyCardSuccessfullyCreated(String expectedText) throws InterruptedException {
        Thread.sleep(1000);
        verifyElementText(cardName, expectedText);
        return this;
    }

    public BoardPage verifyPrivateCard() {
        verifyElementPresent(lockIcon);
        return this;
    }

    public BoardPage clickArchiveListMenu() {
        click(archiveListMenu);
        return this;
    }
}
