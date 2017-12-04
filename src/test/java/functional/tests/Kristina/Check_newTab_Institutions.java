package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Check_newTab_Institutions extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By INSITUTIONS_LOCATOR = By.xpath("//a[text()='Institutions']");


    @Test
    public void checkInstitutionLink() {
        getPageByURL(WILEY_URL);
        getInstitutionsElement().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals("https://edservices.wiley.com/", driver.getCurrentUrl());
    }


    private WebElement getInstitutionsElement() {
        return driver.findElement(INSITUTIONS_LOCATOR);
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}

