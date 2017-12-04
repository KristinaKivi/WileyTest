package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Check_ResourcesFor_menu extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By STUDENTS_LOCATOR = By.xpath("//a[text()='Students']");
    private static final List<String> LINK_TITLES = Arrays.asList("Authors", "Librarians",
            "Booksellers", "Instructors", "Students", "Government Employees", "Societies", "Corporate Partners");

    @Test
    public void search_resourses() {
        getPageByURL(WILEY_URL);
        getStudentsElement().click();
        List<WebElement> links = driver.findElements(By.cssSelector(".autonavLevel1 > li"));
        Assert.assertTrue (links.size() == 8);
        for (int i = 0; i < links.size(); i++) {
            String actualTitle = links.get(i).findElement(By.cssSelector("*")).getText();
            Assert.assertTrue(LINK_TITLES.get(i).equals(actualTitle));
        }
    }
    private WebElement getStudentsElement() {
        return driver.findElement(STUDENTS_LOCATOR);
    }
    private void getPageByURL(String url) {
        driver.get(url);
    }
}


