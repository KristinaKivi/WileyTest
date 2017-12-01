package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class CheckListItems9 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By INPUT_TOP_LOCATOR = By.cssSelector("input.search-form-text");
    private static final String KEYS_TO_ENTER = "for dummies";
    private static final By MAGNIFIER_LOCATOR = By.cssSelector(".icon.icon__search.search-form-submit");
    private static final By HOME_LOCATOR = By.xpath("//a[text()='Home']");
    private static final By PRODUCT_TITLE_LOCATOR = By.cssSelector("h1.productDetail-title");

    @Test()
    public void check_email() {
        getPageByURL(WILEY_URL);
        getInputTopElement().sendKeys(KEYS_TO_ENTER);
        getMagnifierElement().click();
        int linksSize = driver.findElements(By.cssSelector(".product-listing.size100")).size();
        assert (linksSize != 0);
        List<WebElement> links = driver.findElements(By.cssSelector(".product-title > a"));
        int randomIndex = new Random().nextInt(links.size());
        WebElement link = links.get(randomIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        String productTitle = links.get(randomIndex).getText();
        link.click();
        Assert.assertEquals(driver.findElement(PRODUCT_TITLE_LOCATOR).getText(), productTitle);
        getHomeElement().click();

    }

    private WebElement getHomeElement() {
        return driver.findElement(HOME_LOCATOR);
    }

    private WebElement getMagnifierElement() {
        return driver.findElement(MAGNIFIER_LOCATOR);
    }

    private WebElement getInputTopElement() {
        return driver.findElement(INPUT_TOP_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}

