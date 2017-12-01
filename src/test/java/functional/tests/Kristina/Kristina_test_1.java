package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Kristina_test_1 extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.ru/";
    private static final String KEYS_TO_ENTER = "345";
    private static final By CONTACTS_TAB_LOCATOR = By.cssSelector("a[href='./Contacts.html']");

    @Test
    public void search_in_google() {
        getPageByURL(WILEY_URL);
        getContactsElement().click();
        getContactsElement().sendKeys(KEYS_TO_ENTER);
    }

    private WebElement getContactsElement() {
        return getDriver().findElement(CONTACTS_TAB_LOCATOR);
    }

    private WebDriver getDriver() {
        return new ChromeDriver();
    }

    private void getPageByURL(String url) {
        getDriver().get(url);
    }
}