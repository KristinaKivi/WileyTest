package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Check_Invalid_Email extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By INPUT_LOCATOR = By.cssSelector("input.text");
    private static final String KEYS_TO_ENTER = "workgmail.ru";


    @Test
    public void check_email() {
        getPageByURL(WILEY_URL);
        getInputElement().sendKeys(KEYS_TO_ENTER);
        clickOnHomePageArrow();
        checkAlert();
    }
    private void clickOnHomePageArrow() {
        // Click with Selenium doesn't work so i will use click with js
        WebElement element = driver.findElement(By.cssSelector(".homepage-signup-hidden"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        jse.executeScript("arguments[0].click();", element);
    }
    private void checkAlert() {
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue (alert.getText().equals("Invalid email address."));
        alert.accept();
    }
    private void getPageByURL(String url) { driver.get(url); }
    private WebElement getInputElement() {
        return driver.findElement(INPUT_LOCATOR);
    }
}