package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class SchedulePage extends BasePage {

    @FindBy(xpath = "//div[@class='SchedulePage_eventsSection__setPublic__2aXJG']")
    WebElement scheduleHeader;
    @FindBy(xpath = "//div[@class='GlobalActionButton_container__EJ7Lh']")
    WebElement createEventButton;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement postEventButton;
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement inputEventTittle;
    @FindBy(xpath = "//div[@class='EventList_showEvents__kOuHt'][1]//div[@class='Event_contentSection__header__title__19Km8']//h1")
    WebElement tittleHeader;
    @FindBy(xpath = "//span[@class='MuiSwitch-root MuiSwitch-sizeMedium css-ecvcn9']")
    WebElement privateToggle;
    @FindBy(xpath = "//div[@class='CreateEventPage_eventsSection__schedule__3tdog']/div[1]/div[2]/div[1]//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
    WebElement datePickerStartButton;
    @FindBy(xpath = "//div[@class='CreateEventPage_eventsSection__schedule__3tdog']/div[2]/div[2]/div[1]//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
    WebElement getDatePickerEndButton;
    @FindBy(xpath = "//div[@class='css-l0iinn']/div[1]//div[@class='css-1v994a0']")
    WebElement monthElm;
    @FindBy(xpath = "//div[@class='css-l0iinn']/div[2]//div[@class='css-1v994a0']")
    WebElement yearElm;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart MuiIconButton-sizeSmall css-fp6ecq']")
    WebElement dateNextButton;
    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement calendarNextButton;
    @FindBy(xpath = "//div[@class='EventList_showEvents__kOuHt'][1]//div[@class='Event_contentSection__header__title__19Km8']//h1/*[name()='svg']")
    WebElement lockIcon;
    @FindBy(xpath = "//div[@id='notistack-snackbar']")
    WebElement snackBarNotif;
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    WebElement cancelButton;
    @FindBy(xpath = "//div[@class='fr-wrapper show-placeholder']//div")
    WebElement inputNotes;

    public SchedulePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SchedulePage verifyPage() {
        verifyElementPresent(scheduleHeader);
        return this;
    }

    public SchedulePage clickCreateEventButton() {
        click(createEventButton);
        return this;
    }

    public SchedulePage verifyCreateEventPage() {
        verifyElementPresent(postEventButton);
        return this;
    }

    public SchedulePage inputEventTittle(String text) {
        writeText(inputEventTittle, text);
        return this;
    }

    public SchedulePage clickPostButton() {
        click(postEventButton);
        return this;
    }

    public SchedulePage verifyEventTittle(String text) throws InterruptedException {
        Thread.sleep(2000);
        WebElement event = driver.findElement(By.xpath("//div[@class='SchedulePage_eventsSection__items__1HsQZ']"));
        List<WebElement> listEvent = event.findElements(By.xpath("//div[@class='EventList_showEvents__kOuHt']//h1"));

        boolean b = false;
        for (WebElement cell : listEvent) {
            String cellText = cell.getText();
            if (cellText.contains(text)) {
                b = true;
                break;
            }
        }

        if (!b) {
            throw new Error("event not found");
        }

        return this;
    }

    public SchedulePage verifyPrivateEventTittle(String text) throws InterruptedException {
        Thread.sleep(2000);
        WebElement event = driver.findElement(By.xpath("//div[@class='SchedulePage_eventsSection__items__1HsQZ']"));
        List<WebElement> listEvent = event.findElements(By.xpath("//div[@class='EventList_showEvents__kOuHt']//h1"));

        boolean b = false;
        for (WebElement cell : listEvent) {
            String cellText = cell.getText();
            if (cellText.contains(text) && lockIcon.isDisplayed()) {
                b = true;
                break;
            }
        }

        if (!b) {
            throw new Error("event not found");
        }

        return this;
    }

    public SchedulePage clickPrivateToggle() {
        click(privateToggle);
        return this;
    }

    public SchedulePage selectDatePickerStart(String date, String monthAndYear) throws InterruptedException {
        click(datePickerStartButton);
        Thread.sleep(1000);
        while(true){
            String titleText = monthElm.getText() + " " + yearElm.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                dateNextButton.click();
            }
        }
        Thread.sleep(1000);
        By dateElm = By.xpath("//div[@class='MuiCalendarPicker-root css-1brzq0m']//div[@class='PrivatePickersSlideTransition-root css-dhopo2']//*[.='"+date+"']");
        driver.findElement(dateElm).click();
        return this;
    }

    public SchedulePage selectDatePickerEnd(String date, String monthAndYear) throws InterruptedException {
        click(getDatePickerEndButton);
        Thread.sleep(1000);
        while(true){
            String titleText = monthElm.getText() + " " + yearElm.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                dateNextButton.click();
            }
        }
        Thread.sleep(1000);
        By dateElm = By.xpath("//div[@class='MuiCalendarPicker-root css-1brzq0m']//div[@class='PrivatePickersSlideTransition-root css-dhopo2']//*[.='"+date+"']");
        driver.findElement(dateElm).click();
        return this;
    }

    public SchedulePage selectCalendarDate(String date, String monthAndYear) throws InterruptedException {
        Thread.sleep(2000);
        int divPosition = 1;
        while(true){
            By monthYearElmLeft = By.xpath("//div[@class='DayPicker-Months']/div[1]//div[@class='DayPicker-Caption']/div");
            By monthYearElmRight = By.xpath("//div[@class='DayPicker-Months']/div[2]//div[@class='DayPicker-Caption']/div");
            String monthYearLeft = driver.findElement(monthYearElmLeft).getText();
            String monthYearRight = driver.findElement(monthYearElmRight).getText();

            if(monthYearLeft.equals(monthAndYear)){
                divPosition = 1;
                break;
            } else if (monthYearRight.equals(monthAndYear)) {
                divPosition = 2;
                break;
            } else {
                calendarNextButton.click();
            }
        }

        Thread.sleep(1000);
        By dateElm = By.xpath("//div[@class='DayPicker-Months']/div["+ divPosition +"]/div[@class='DayPicker-Body']//*[.='"+ date +"']");
        driver.findElement(dateElm).click();
        return this;
    }

    public SchedulePage verifyErrorSelectDate(String expectedText) {
        verifyElementText(snackBarNotif, expectedText);
        return this;
    }

    public SchedulePage clickCancelButton() {
        click(cancelButton);
        return this;
    }

    public SchedulePage moveCalendarDate(String monthAndYear) throws InterruptedException {
        while(true){
            By monthYearElmLeft = By.xpath("//div[@class='DayPicker-Months']/div[1]//div[@class='DayPicker-Caption']/div");
            By monthYearElmRight = By.xpath("//div[@class='DayPicker-Months']/div[2]//div[@class='DayPicker-Caption']/div");
            String monthYearLeft = driver.findElement(monthYearElmLeft).getText();
            String monthYearRight = driver.findElement(monthYearElmRight).getText();

            if(monthYearLeft.equals(monthAndYear)){
                break;
            } else if (monthYearRight.equals(monthAndYear)) {
                break;
            } else {
                calendarNextButton.click();
            }
        }
        return this;
    }

    public SchedulePage verifyCalendarPosition(String monthAndYear) {
        WebElement monthYearElm = driver.findElement(By.xpath("//div[@class='DayPicker-Months']"));
        List<WebElement> listMonthYear = monthYearElm.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
        boolean b = false;
        for (WebElement cell : listMonthYear) {
            String cellText = cell.getText();
            if (cellText.contains(monthAndYear)) {
                b = true;
                break;
            }
        }

        if (!b) {
            throw new Error("month and year not found");
        }
        return this;
    }

    public SchedulePage inputNotes(String text) throws InterruptedException {
        click(inputNotes);
        Thread.sleep(1000);
        writeText(inputNotes, text);
        return this;
    }

}
