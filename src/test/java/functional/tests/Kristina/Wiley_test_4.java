package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wiley_test_4 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By CU_LOCATOR = By.xpath("//a[text()='Contact Us']");

    @Test
    public void search_in_wiley() {
        getPageByURL(WILEY_URL);
        Assert.assertTrue(getCUElement().isDisplayed());
    }

    private WebElement getCUElement() {
        return driver.findElement(CU_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}