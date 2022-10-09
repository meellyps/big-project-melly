package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

    public static void getToken(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0], arguments[1])", "token",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjYyZjcxZjZiNTkwOWRiM2IxNDhmMTNmZCIsImdvb2dsZUlkIjoiMTA2OTQ3NTU4NjI2MTI4MjUwMzExIiwiZW1haWwiOiJtZWxseXB1c3BpdGEyMUBnbWFpbC5jb20iLCJmdWxsTmFtZSI6Im1lbGx5IHB1c3BpdGEgc2FyaSIsInBob3RvVXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EtL0FGZFp1Y3JfWnh3ZUg1U0ZaTVFrODM5SXV4QlpnX0taZFhXOFpxeEVUOVIxX1E9czk2LWMiLCJiaW8iOiJUZXN0IEJpb1Rlc3QgQmlvVGVzdCBCaW8iLCJzdGF0dXMiOiJNYW5hZ2VyTWFuYWdlck1hbmFnZXIiLCJkZWZhdWx0Q29tcGFueSI6eyJfaWQiOiI2MzJlNjdiNDNjNmUxMDE3NzI2M2E5ZWEifSwiY3JlYXRlZEF0IjoiMjAyMi0wOC0xM1QwMzo1MDowMy43MTdaIiwidXBkYXRlZEF0IjoiMjAyMi0wOS0yNFQwMjoxMzowOC42NDlaIiwiX192IjowfSwiaWF0IjoxNjYzOTg2MDM2LCJleHAiOjE2NjY1NzgwMzZ9.6-KQvPoLtTau_pyZS4ePkRe5UpSDv5kvpmy9EghsbVY");
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
