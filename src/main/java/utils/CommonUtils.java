package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

    public static void setToken(WebDriver driver, String token) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0], arguments[1])", "token", token);
        driver.navigate().refresh();
    }

    public static void uploadFile(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.evaluate('//div[2]/div/div/input', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null,).singleNodeValue.setAttribute('style', 'display: block;')");
    }

    public static int randomNumber(int min, int max) {
        int number = (int)(Math.random()*(max-min+1)+min);
        return number;
    }
}
