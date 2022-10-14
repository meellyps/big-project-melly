package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BoardPage;
import page.TeamPage;

import static stepDef.Hooks.driver;

public class BoardStepDef {
    private String verifyBoardPageText = "Kanban Board - QA-14-BP-B";
    private String inputListNameText = "To Do";
    private String inputListNameForArchiveText = "Archive List";
    private String listActionHeaderText =  "List Action";
    private String setCompleteNotifText = "Set list as Complete is success";
    private String unSetCompleteNotifText = "Unset list from Complete is success";
    private String cardNameText = "Story 1";
    private String successCreateCardNotif = "Creating card is success";
    private String successArhiveListNotif = "To Do list has been moved to archived";
    private String listNameCannotEmptyText = "List name cannot be empty";
    private String cardNameCannotEmptyText = "Card name cannot be empty";


    TeamPage teamPage = new TeamPage(driver);
    BoardPage boardPage = new BoardPage(driver);

    @Given("user is on the team page")
    public void userIsOnTheTeamPage() throws InterruptedException {
        Thread.sleep(1000);
        teamPage.verifyPage();
    }

    @When("user select board card")
    public void userSelectBoardCard() {
        teamPage.clickBoardCard();
    }

    @When("user select board menu in the overview option button")
    public void userSelectBoardMenuInTheOverviewOptionButton() {
        teamPage.clickOverviewButton()
                .clickBoardButton();
    }

    @Then("user should be navigated to board page")
    public void userShouldBeNavigatedToBoardPage() {
        boardPage.verifyPage();
    }

    @And("user create new list")
    public void userCreateNewList() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifyPage()
                .clickAddListButton()
                .inputListName(inputListNameText)
                .clickCreateButton();
    }

    @Then("list should be successfully created")
    public void listShouldBeSuccessfullyCreated() {
        boardPage.verifyListNameText(inputListNameText);
    }

    @And("user select list action menu")
    public void userSelectListActionMenu() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifyPage()
                .clickListActionMenuButton();
    }

    @Then("list action menu should be displayed")
    public void listActionMenuShouldBeDisplayed() {
        boardPage.verifyListActionHeader(listActionHeaderText);
    }

    @And("user select set as complete list from list action menu")
    public void userSelectSetAsCompleteListFromListActionMenu() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifyPage()
                .clickListActionMenuButton()
                .clickSetCompleteMenu();
    }

    @Then("list should be set as complete")
    public void listShouldBeSetAsComplete() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(setCompleteNotifText)
                .verifyListCompleted();
    }

    @And("user select unset complete list from list action menu")
    public void userSelectUnsetCompleteListFromListActionMenu() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifyPage()
                .clickListActionMenuButton()
                .clickSetCompleteMenu();
    }

    @Then("list should be set as incomplete")
    public void listShouldBeSetAsIncomplete() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(unSetCompleteNotifText);
    }

    @And("user create new card")
    public void userCreateNewCard() {
        boardPage.verifyPage()
                .clickAddCard()
                .inputCardName(cardNameText)
                .clickSubmitAddCardButton();
    }
    @Then("card successfully created")
    public void cardSuccessfullyCreated() throws InterruptedException {
        boardPage.verifySnackBarNotif(successCreateCardNotif)
                .verifyCardSuccessfullyCreated(cardNameText);
    }

    @And("user set card as private")
    public void userSetCardAsPrivate() {
        boardPage.clickPrivateCard();
    }

    @Then("card successfully created as private")
    public void cardSuccessfullyCreatedAsPrivate() throws InterruptedException {
        boardPage.verifySnackBarNotif(successCreateCardNotif)
                .verifyCardSuccessfullyCreated(cardNameText)
                .verifyPrivateCard();
    }

    @And("user create new private card")
    public void userCreateNewPrivateCard() {
        boardPage.verifyPage()
                .clickAddCard()
                .inputCardName(cardNameText)
                .clickPrivateCard()
                .clickSubmitAddCardButton();
    }

//    @And("user create new list with card inside")
//    public void userCreateNewListWithCardInside() throws InterruptedException {
//        Thread.sleep(1000);
//        boardPage.verifyPage()
//                .clickAddListButton()
//                .inputListName(inputListNameForArchiveText)
//                .clickCreateButton();
//
//        Thread.sleep(1000);
//        boardPage.clickAddCard()
//                .inputCardName(cardNameText)
//                .clickSubmitAddCardButton();
//    }

    @And("user archive the list")
    public void userArchiveTheList() {
        boardPage.clickListActionMenuButton()
                .clickArchiveListMenu();
    }

    @Then("list successfully archived")
    public void listSuccessfullyArchived() throws InterruptedException {
        boardPage.verifySnackBarNotif(successArhiveListNotif);
    }

    @And("user create new list with empty list name")
    public void userCreateNewListWithEmptyListName() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifyPage()
                .clickAddListButton()
                .inputListName("")
                .clickCreateButton();
    }

    @Then("user should be shown error message List name cannot be empty")
    public void userShouldBeShownErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(listNameCannotEmptyText);
        Thread.sleep(1000);

    }

    @And("user create new card with empty card name")
    public void  userCreateNewCardWithEmptyCardName() {
        boardPage.verifyPage()
                .clickAddCard()
                .inputCardName("")
                .clickSubmitAddCardButton();
    }

    @Then("user should be shown error message card name cannot be empty")
    public void userShouldBeShownErrorMessageCardNameCannotBeEmpty() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(cardNameCannotEmptyText);
    }

}
