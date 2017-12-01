package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wiley_test_2 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By SUBJECTS_LOCATOR = By.xpath("//a[text()='Subjects']");

    @Test
    public void search_in_wiley() {
        getPageByURL(WILEY_URL);
        // getSubjectsElement().click(); // клик сработал
        Assert.assertTrue(getSubjectsElement().isDisplayed());
    }

    private WebElement getSubjectsElement() {
        return driver.findElement(SUBJECTS_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}