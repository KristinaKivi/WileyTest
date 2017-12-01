package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wiley_test_5 extends BaseTest {
    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By HELP_LOCATOR = By.xpath("//a[text()='Help']");

    @Test
    public void search_in_wiley() {
        getPageByURL(WILEY_URL);
        Assert.assertTrue(getHelpElement().isDisplayed());
    }

    private WebElement getHelpElement() {
        return driver.findElement(HELP_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}