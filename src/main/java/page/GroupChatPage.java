package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class GroupChatPage extends BasePage {

    @FindBy(xpath = "//div[@class='SideBarGroupChatSection_header__1a6Fw']/p")
    WebElement groupChatMemberHeader;
    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    WebElement inputMessage;
    @FindBy(xpath = "//div[@class='CreateMessage_send__2f1ZQ']")
    WebElement sendMessageButton;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_content__21YIN']//p")
    WebElement myLastMessageBalloon;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_content__21YIN']//i")
    WebElement myLastMessageBalloonDeleted;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_timeStamp__2XRSu']//p")
    WebElement myLastMessageTime;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_iconOption__3F-Ru']/*[name()='svg']")
    WebElement myLastMessageOptionButton;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_iconOption__3F-Ru']/following-sibling::div//p[.='Delete Message']")
    WebElement deleteMessageMenu;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_balloon__zRoXK']//div[2]/div/*[name()='svg']")
    WebElement cancelDeleteButton;
    @FindBy(xpath = "//div[@class='modal-title h4']")
    WebElement modalDeleteHeader;
    @FindBy(xpath = "//div[@role='dialog']//button[@class='btn btn-danger btn-block btn-sm']")
    WebElement modalDeleteButton;
    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    WebElement snackBarNotif;
    @FindBy(xpath = "//input[@type='file']")
    WebElement inputImage;
    @FindBy(xpath = "//input[@type='file']")
    WebElement inputFile;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_content__21YIN']//p/a")
    WebElement linkMessage;
    @FindBy(xpath = "//div[@class='tribute-container']//li[1]")
    WebElement mentionMemberList;
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_content__21YIN']//p//a")
    WebElement mentionMemberMessage;
    By sendLoading = By.xpath("//div[@class='OverlayButton_box__2jFLd OverlayButton_contentOverlay__2zHVV']");
    By spinnerLoading = By.xpath("//div[@class='spinner-border spinner-border-sm text-warning']");


    public GroupChatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GroupChatPage verifyPage() {
        verifyElementPresent(groupChatMemberHeader);
        return this;
    }

    public GroupChatPage writeMessage(String text) {
        writeText(inputMessage, text);
        return this;
    }

    public GroupChatPage writeLinkMessage(String text) {
        writeText(inputMessage, text);
        writeText(inputMessage, " ");
        inputMessage.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public GroupChatPage sendMessage() {
        click(sendMessageButton);
        return this;
    }

    public GroupChatPage verifyMyTextMessageHasBeenSent(String expectedText, String messageTime) throws InterruptedException {
        waitInvisibility(sendLoading);
        waitInvisibility(spinnerLoading);
        String lastMessageTime = readText(myLastMessageTime);
        int i = 0;
        while (!lastMessageTime.equals(messageTime)) {
            if (i == 5) {
                throw new Error("message not found");
            }
            lastMessageTime = readText(myLastMessageTime);
            i++;
            Thread.sleep(1000);
        }

        verifyElementText(myLastMessageBalloon, expectedText);
        return this;
    }

    public GroupChatPage clickMessageOptionButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myLastMessageBalloon);
        actions.moveToElement(myLastMessageOptionButton);
        actions.click().build().perform();
        return this;
    }

    public GroupChatPage clickDeleteMessageMenu() {
        click(deleteMessageMenu);
        return this;
    }

    public GroupChatPage clickCancelDeleteButton() {
        click(cancelDeleteButton);
        return this;
    }

//    public GroupChatPage verifyMessagenotDeleted() {
//        click(myLastMessageBalloon);
//        return this;
//    }

    public GroupChatPage verifyModalDelete() {
        verifyElementText(modalDeleteHeader, "Delete Message?");
        return this;
    }

    public GroupChatPage clickModalDeleteButton() {
        click(modalDeleteButton);
        return this;
    }

    public GroupChatPage verifySnackBarNotif(String expectedText) {
        verifyElementText(snackBarNotif, expectedText);
        return this;
    }

    public GroupChatPage verifyMessageHasBeenDeleted(String expectedText) {
        verifyElementText(myLastMessageBalloonDeleted, expectedText);
        return this;
    }

    public GroupChatPage inputImage(String imagePath) throws InterruptedException {
        Thread.sleep(1000);
        CommonUtils.uploadFile(driver);
        writeText(inputImage, imagePath);
        Thread.sleep(2000);
        return this;
    }

    public GroupChatPage inputFile(String filePath) throws InterruptedException {
        Thread.sleep(1000);
        CommonUtils.uploadFile(driver);
        writeText(inputFile, filePath);
        Thread.sleep(2000);
        return this;
    }

    public GroupChatPage verifyMyLinkMessageHasBeenSent(String expectedText, String messageTime) throws InterruptedException {
        waitInvisibility(sendLoading);
        waitInvisibility(spinnerLoading);
        String lastMessageTime = readText(myLastMessageTime);
        int i = 0;
        while (!lastMessageTime.equals(messageTime)) {
            if (i == 5) {
                throw new Error("message not found");
            }
            lastMessageTime = readText(myLastMessageTime);
            i++;
            Thread.sleep(1000);
        }

        verifyElementHref(linkMessage, expectedText);
        return this;
    }

    public GroupChatPage writeMessageWithMention(String text) throws InterruptedException {
        writeText(inputMessage, text);
        Thread.sleep(1000);
        click(mentionMemberList);
        return this;
    }

    public GroupChatPage verifyMessageWithMentionMemberHasBeenSent(String expectedText, String messageTime) throws InterruptedException {
        waitInvisibility(sendLoading);
        waitInvisibility(spinnerLoading);
        String lastMessageTime = readText(myLastMessageTime);
        int i = 0;
        while (!lastMessageTime.equals(messageTime)) {
            if (i == 5) {
                throw new Error("message not found");
            }
            lastMessageTime = readText(myLastMessageTime);
            i++;
            Thread.sleep(1000);
        }

        verifyElementText(mentionMemberMessage, expectedText);
        return this;
    }
}

