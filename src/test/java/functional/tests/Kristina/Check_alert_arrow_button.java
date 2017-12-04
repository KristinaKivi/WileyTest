package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Check_alert_arrow_button extends BaseTest {


    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";


    @Test
    public void Click_home() {
        getPageByURL(WILEY_URL);

        clickOnHomePageArrow();
        checkAlert();

    private void clickOnHomePageArrow() {
        // Click with Selenium doesn't work so i will use click with js
        WebElement element = driver.findElement(By.cssSelector(".homepage-signup-hidden"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView()", element);
        jse.executeScript("arguments[0].click();", element);
    }

    private void checkAlert() {
        Alert alert = driver.switchTo().alert();
        assert (alert.getText().equals("Please enter email address"));
        alert.accept();
    }

        private void getPageByURL(String url) {
        driver.get(url);
    }
}
