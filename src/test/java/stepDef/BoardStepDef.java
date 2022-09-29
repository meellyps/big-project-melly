package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BoardPage;
import page.TeamPage;

import static stepDef.Hooks.driver;
import static stepDef.Hooks.verifyTeamPageText;

public class BoardStepDef {
    private String verifyBoardPageText = "Kanban Board - QA-14-BP-B";
    private String inputListNameText = "To Do";
    private String listActionHeaderText =  "List Action";
    private String setCompleteNotifText = "Set list as Complete is success";
    private String unSetCompleteNotifText = "Unset list from Complete is success";

    TeamPage teamPage = new TeamPage(driver);
    BoardPage boardPage = new BoardPage(driver);

    @Given("user is on the team page")
    public void userIsOnTheTeamPage() {
        teamPage.verifyPage(verifyTeamPageText);
    }

    @When("user click board card")
    public void userClickBoardCard() {
        teamPage.clickBoardCard();
    }

    @When("user click board in the overview option button")
    public void userClickoverviewButton() {
        teamPage.clickOverviewButton()
                .clickBoardButton();
    }

    @Then("user should be navigated to board page")
    public void userShouldBeNavigatedToBoardPage() {
        boardPage.verifyPage(verifyBoardPageText);
    }

    @And("user create new list")
    public void userCreateNewList() throws InterruptedException {
        Thread.sleep(2000);
        boardPage.verifyPage(verifyBoardPageText)
                .clickAddListButton()
                .inputListName(inputListNameText)
                .clickCreateButton();
    }

    @Then("list should be successfully created")
    public void listShouldBeSuccessfullyCreated() {
        boardPage.verifyListNameText(inputListNameText);
    }

    @When("user click list action menu")
    public void clickListActionMenu() throws InterruptedException {
        Thread.sleep(2000);
        boardPage.verifyPage(verifyBoardPageText)
                .clickChecklistButton();
    }

    @Then("list action menu should be displayed")
    public void listActionMenuShouldBeDisplayed() {
        boardPage.verifyListActionHeader(listActionHeaderText);
    }

    @When("user click set as complete list from list action menu")
    public void userClickSetAsCompleteListFromListActionMenu() throws InterruptedException {
        Thread.sleep(2000);
        boardPage.verifyPage(verifyBoardPageText)
                .clickChecklistButton()
                .clickSetCompleteMenu();
    }

    @Then("list should be set as complete")
    public void listShouldBeSetAsComplete() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(setCompleteNotifText)
                .verifyListCompleted();
    }

    @When("user click unset complete list from list action menu")
    public void userClickUnsetCompleteListFromListActionMenu() throws InterruptedException {
        Thread.sleep(2000);
        boardPage.verifyPage(verifyBoardPageText)
                .clickChecklistButton()
                .clickSetCompleteMenu();
    }

    @Then("list should be set as incomplete")
    public void listShouldBeSetAsIncomplete() throws InterruptedException {
        Thread.sleep(1000);
        boardPage.verifySnackBarNotif(unSetCompleteNotifText)
                .verifyListIncomplete();
    }

}
