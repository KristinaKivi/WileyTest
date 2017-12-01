package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wiley_test_3 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By AW_LOCATOR = By.xpath("//a[text()='About Wiley']");

    @Test
    public void search_in_wiley() {
        getPageByURL(WILEY_URL);
        Assert.assertTrue(getAWElement().isDisplayed());
    }

    private WebElement getAWElement() {
        return driver.findElement(AW_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}