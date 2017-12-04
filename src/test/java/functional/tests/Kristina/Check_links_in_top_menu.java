package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Check_links_in_top_menu extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By HOME_LOCATOR = By.xpath("//a[text()='Home']");
    private static final By SUBJECTS_LOCATOR = By.xpath("//a[text()='Subjects']");
    private static final By AW_LOCATOR = By.xpath("//a[text()='About Wiley']");
    private static final By CU_LOCATOR = By.xpath("//a[text()='Contact Us']");
    private static final By HELP_LOCATOR = By.xpath("//a[text()='Help']");

    @Test
    public void search_in_top_menu() {
        getPageByURL(WILEY_URL);
        Assert.assertTrue(getHomeElement().isDisplayed());
        Assert.assertTrue(getSubjectsElement().isDisplayed());
        Assert.assertTrue(getAWElement().isDisplayed());
        Assert.assertTrue(getCUElement().isDisplayed());
        Assert.assertTrue(getHelpElement().isDisplayed());

    }
    private WebElement getHelpElement() {
        return driver.findElement(HELP_LOCATOR);
    }
    private WebElement getCUElement() {
        return driver.findElement(CU_LOCATOR);
    }
    private WebElement getAWElement() {
        return driver.findElement(AW_LOCATOR);
    }
    private WebElement getSubjectsElement() {
        return driver.findElement(SUBJECTS_LOCATOR);
    }
    private WebElement getHomeElement() {
        return driver.findElement(HOME_LOCATOR);
    }
    private void getPageByURL(String url) {
        driver.get(url);
    }
}