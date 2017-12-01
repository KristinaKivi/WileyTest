package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wiley_test_1 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By HOME_LOCATOR = By.xpath("//a[text()='Home']");

    @Test
    public void search_in_wiley() {
        getPageByURL(WILEY_URL);
        Assert.assertTrue(getHomeElement().isDisplayed());
    }

    private WebElement getHomeElement() {
        return driver.findElement(HOME_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}