package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Check_Students_url extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By STUDENTS_LOCATOR = By.xpath("//a[text()='Students']");
    private static final By STUDENTS_HEADER = By.xpath("//h1[text()='Students']");

    @Test
    public void CheckUrl() {
        getPageByURL(WILEY_URL);
        getStudentsElement().click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.wiley.com/WileyCDA/Section/id-404702.html");
        Assert.assertTrue(getStudentsHElement().isDisplayed());
    }

    private WebElement getStudentsHElement() {
        return driver.findElement(STUDENTS_HEADER);
    }

    private WebElement getStudentsElement() {
        return driver.findElement(STUDENTS_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}