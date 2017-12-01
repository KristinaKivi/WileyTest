package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Check6 extends BaseTest {


    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By STUDENTS_LOCATOR = By.xpath("//a[text()='Students']");
    private static final By HOME_LOCATOR = By.xpath("//a[text()='Home']");


    @Test
    public void Click_home() {
        getPageByURL(WILEY_URL);
        getStudentsElement().click();
        getHomeElement().click();

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
        assert (alert.getText().equals("Please enter email address"));
        alert.accept();
    }

    private WebElement getStudentsElement() {
        return driver.findElement(STUDENTS_LOCATOR);
    }

    private WebElement getHomeElement() {
        return driver.findElement(HOME_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}
