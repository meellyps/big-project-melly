package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardPage extends BasePage {
    @FindBy(xpath = "//div[@class='GeneralSubNavBar_title__text__3UFWr indiana-scroll-container indiana-scroll-container--hide-scrollbars']/h1")
    WebElement boardHeader;
    @FindBy(xpath = "//div[@class='CreateListButton_buttonBottom__16OpZ']/ancestor::button")
    WebElement addListButton;
    @FindBy(xpath = "//input[@name='name']")
    WebElement inputListName;
    @FindBy(xpath = "//div[@class='Button_container__1WNuB']")
    WebElement createButton;
    @FindBy(xpath = "//div[@class='ListContainer_headerSection__title__text__36H_r']/h1")
    WebElement toDoListName;
    @FindBy(xpath = "//div[@class='ListContainer_ListContainer__outerList__1PG0-']/div[1]//div[@class='ListContainer_headerSection__more__3On04']")
    WebElement listActionButton;
    @FindBy(xpath = "//div[@class='ListMenu_headerSection__JaHkO']")
    WebElement listActionHeader;
    @FindBy(xpath = "//div[@class='ListMenu_bodySection__1jhZS']//div[@class='OverlayButton_box__2jFLd']/div[3]")
    WebElement setCompleteListMenu;
    @FindBy(xpath = "//div[@class='ListContainer_headerSection__title__completeIcon__2MbRJ']")
    WebElement checkListCompleted;
    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    WebElement snackBarNotif;

    public BoardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BoardPage verifyPage(String expectedText) {
        verifyElementText(boardHeader, expectedText);
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
        createButton.click();
        return this;
    }

    public BoardPage verifyListNameText(String expectedText) {
        verifyElementText(toDoListName, expectedText);
        return this;
    }

    public BoardPage clickChecklistButton() {
        listActionButton.click();
        return this;
    }

    public BoardPage verifyListActionHeader(String expectedText) {
        verifyElementText(listActionHeader, expectedText);
        return this;
    }

    public BoardPage clickSetCompleteMenu() {
        setCompleteListMenu.click();
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
        verifyElementNotPresent(checkListCompleted);
        return this;
    }
}
