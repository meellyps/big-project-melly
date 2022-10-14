package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.SchedulePage;
import page.TeamPage;
import utils.CommonUtils;

import static stepDef.Hooks.driver;

public class ScheduleStepDef {

    private String tittleEventText = "Meeting New Product";
    private String monthAndYear = "November 2022";
    private int intDate = CommonUtils.randomNumber(2, 29);
    private String startDate = String.valueOf(intDate );
    private String endDate = String.valueOf(intDate-1);
    private String fillNotesText = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    TeamPage teamPage = new TeamPage(driver);
    SchedulePage schedulePage = new SchedulePage(driver);

    @When("user select schedule card")
    public void userSelectScheduleCard() {
        teamPage.clickScheduleCard();
    }

    @When("user select schedule menu in the overview option button")
    public void userSelectScheduleMenuInTheOverviewOptionButton() {
        teamPage.clickOverviewButton()
                .clickScheduleButton();
    }

    @Then("user should be navigated to schedule page")
    public void userShouldBeNavigatedToSchedulePage() {
        schedulePage.verifyPage();
    }

    @And("user select create event button")
    public void userSelectCreateEventButton() {
        schedulePage.clickCreateEventButton();
    }

    @Then("user should be navigated to create event page")
    public void userShouldBeNavigatedToCreateEventPage() {
        schedulePage.verifyCreateEventPage();
    }

    @And("user create event")
    public void userCreateEvent() throws InterruptedException {
        schedulePage.clickCreateEventButton()
                .inputEventTittle(tittleEventText)
                .selectDatePickerStart(startDate, monthAndYear)
                .clickPostButton();
    }

    @Then("user should be successfully created event")
    public void userShouldBeSuccessfullyCreatedEvent() throws InterruptedException {
        schedulePage.verifyPage()
                .selectCalendarDate(startDate, monthAndYear)
                .verifyEventTittle(tittleEventText);
    }

    @And("user create private event")
    public void userCreatePrivateEvent() throws InterruptedException {
        schedulePage.clickCreateEventButton()
                .inputEventTittle(tittleEventText)
                .selectDatePickerStart(startDate, monthAndYear)
                .clickPrivateToggle()
                .clickPostButton();
    }

    @Then("user should be successfully created private event")
    public void userShouldBeSuccessfullyCreatedPrivateEvent() throws InterruptedException {
        schedulePage.verifyPage()
                .selectCalendarDate(startDate, monthAndYear)
                .verifyPrivateEventTittle(tittleEventText);
    }


    @And("user create event with end date before start date")
    public void userCreateEventWithEndDateBeforeStartDate() throws InterruptedException {
        schedulePage.clickCreateEventButton()
                .inputEventTittle(tittleEventText)
                .selectDatePickerStart(startDate, monthAndYear)
                .selectDatePickerEnd(endDate, monthAndYear);
    }

    @Then("^user should see error message (.*)")
    public void userShouldSeeErrorMessage(String errorMessage) {
        schedulePage.verifyErrorSelectDate(errorMessage);
    }

    @And("user create event with empty title")
    public void userCreateEventWithEmptyTitle() {
        schedulePage.clickCreateEventButton()
                .inputEventTittle("")
                .clickPostButton();
    }

    @And("user cancel create event")
    public void userCancelCreateEvent() {
        schedulePage.clickCreateEventButton()
                .clickCancelButton();
    }

    @And("^user move calendar to (.*)")
    public void userMoveCalendarTo(String monthAndYear) throws InterruptedException {
        schedulePage.verifyPage().moveCalendarDate(monthAndYear);
    }

    @Then("^user should be move to (.*)")
    public void userShouldBeMoveTo(String monthAndYear) {
        schedulePage.verifyCalendarPosition(monthAndYear);
    }

    @And("user create event with fill notes more than 500 characters")
    public void userCreateEventWithFillNotes() throws InterruptedException {
        schedulePage.clickCreateEventButton()
                .inputEventTittle(tittleEventText)
                .selectDatePickerStart(startDate, monthAndYear)
                .inputNotes(fillNotesText)
                .clickPostButton();
    }
}
