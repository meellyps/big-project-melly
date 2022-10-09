package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.GroupChatPage;
import page.TeamPage;

import static stepDef.Hooks.driver;

public class GroupChatStepDef {

    private String textMessage = "halo123";
    private String messageTime = "just now";
    private String deleteMessageNotif = "Delete group chat message success";
    private String imageFileName = "wp7896435.jpg";
    private String fileName = "day6.zip";
    private String imagePath = "D:\\adiladios\\project\\java\\big-project-melly\\src\\main\\resources\\" + imageFileName;
    private String filePath = "D:\\adiladios\\project\\java\\big-project-melly\\src\\main\\resources\\" + fileName;
    private String emoji = "\u2764";
    private String linkAddress = "https://www.google.com/";
    private String textMessageWithMention = "hallo @melly";
    private String mentionMemberName = "melly puspita sari";

    TeamPage teamPage = new TeamPage(driver);
    GroupChatPage groupChatPage = new GroupChatPage(driver);

    @When("user select group chat card")
    public void userSelectGroupChatCard() {
        teamPage.clickGroupChatCard();
    }

    @When("user select group chat menu in the overview option button")
    public void userSelectGroupChatMenuInTheOverviewOptionButton() {
        teamPage.clickOverviewButton()
                .clickGroupChatButton();
    }

   @Then("user should be navigated to group chat page")
    public void userShouldBeNavigatedToGroupChatPage() {
        groupChatPage.verifyPage();
    }

    @And("send text message")
    public void sendTextMessage() {
        groupChatPage.verifyPage()
                .writeMessage(textMessage)
                .sendMessage();
    }

    @Then("user should see the text message that has been sent")
    public void userShouldSeeTheTextMessageThatHasBeenSent() throws InterruptedException {
        groupChatPage.verifyMyTextMessageHasBeenSent(textMessage, messageTime);
    }

    @And("user delete message")
    public void userDeleteMessage() throws InterruptedException {
        sendTextMessage();
        groupChatPage.verifyPage()
                .clickMessageOptionButton();
        Thread.sleep(1000);
        groupChatPage.clickDeleteMessageMenu()
                .verifyModalDelete()
                .clickModalDeleteButton();
    }

    @Then("^user should see the text message that has been deleted (.*)")
    public void userShouldSeeTheTextMessageThatHasBeenDeleted(String text) {
        groupChatPage.verifySnackBarNotif(deleteMessageNotif)
                .verifyMessageHasBeenDeleted(text);
    }

    @And("send image massage")
    public void sendImageMassage() throws InterruptedException {
        groupChatPage.verifyPage()
                .inputImage(imagePath);
    }

    @Then("user should see the image message that has been sent")
    public void verifyUserShouldSeeTheImageMessageThatHasBeenSent() throws InterruptedException {
        groupChatPage.verifyMyTextMessageHasBeenSent(imageFileName, messageTime);
    }

    @And("send file message")
    public void sendFileMessage() throws InterruptedException {
        groupChatPage.verifyPage()
                .inputFile(filePath);
    }

    @Then("user should see the file message that has been sent")
    public void verifyUserShouldSeeTheFileMessageThatHasBeenSent() throws InterruptedException {
        groupChatPage.verifyMyTextMessageHasBeenSent(fileName, messageTime);
    }

    @And("send emoji message")
    public void sendEmojiMessage() {
        groupChatPage.verifyPage()
                .writeMessage(emoji)
                .sendMessage();
    }

    @Then("user should see the emoji message that has been sent")
    public void userShouldSeeTheEmojiMessageThatHasBeenSent() throws InterruptedException {
        groupChatPage.verifyMyTextMessageHasBeenSent(emoji, messageTime);
    }

    @And("send link message")
    public void sendLinkMessage() {
        groupChatPage.verifyPage()
            .writeLinkMessage(linkAddress)
            .sendMessage();
    }

    @Then("user should see the link message that has been sent")
    public void userShouldSeeTheLinkMessageThatHasBeenSent() throws InterruptedException {
        groupChatPage.verifyMyLinkMessageHasBeenSent(linkAddress, messageTime);
    }

    @And("user send chat with mention member")
    public void userSendChatWithMentionMember() throws InterruptedException {
        groupChatPage.verifyPage()
                .writeMessageWithMention(textMessageWithMention)
                .sendMessage();
    }

    @Then("user successfully sent message with mention member")
    public void userSuccessfullySentMessageWithMentionMember() throws InterruptedException {
        groupChatPage.verifyMessageWithMentionMemberHasBeenSent(mentionMemberName, messageTime);
    }


}
