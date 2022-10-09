package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(WebElement element) {
        waitVisibility(element);
        element.click();
    }

    //Select
    public void selectDropdown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }

    //Write Text
    public void writeText(WebElement element, String text) {
        waitVisibility(element);
        element.sendKeys(text);
    }

    //Clear Text
    public void clearText(WebElement element) {
        waitVisibility(element);
        element.clear();
    }

    //Read Text
    public String readText(WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    //Read Value
    public String readValue(WebElement element) {
        waitVisibility(element);
        return element.getAttribute("value");
    }

    //Wait
    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait
    public void verifyElementText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(text, element.getText());
    }

    public void verifyElementHref(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(text, element.getAttribute("href"));
    }

    public void verifyElementPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(true, element.isDisplayed());
    }

    //Wait
    public void verifyElementTextContains(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().contains(text));
    }

    public BasePage verifyElementInvisible(WebElement element){
        boolean isInvisible = element.isDisplayed();
        Assert.assertFalse(isInvisible);
        return this;
    }
    public void waitInvisibility(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public boolean isNotElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }
}
