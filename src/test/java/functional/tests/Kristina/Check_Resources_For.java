package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.*;

public class Check_Resources_For extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By STUDENTS_LOCATOR = By.xpath("//a[text()='Students']");
    private static final List<String> LINK_TITLES = Arrays.asList("Authors", "Librarians",
            "Booksellers", "Instructors", "Students", "Government Employees", "Societies", "Corporate Partners");

    @Test
    public void search_resourses() {
        getPageByURL(WILEY_URL);
        getStudentsElement().click();
        List<WebElement> links = driver.findElements(By.cssSelector(".autonavLevel1 > li"));
//        assert (links.get(0).getText().equals("Authors"));
//        assert (links.get(1).getText().equals("Librarians"));
//        assert (links.get(2).getText().equals("Booksellers"));
//        assert (links.get(3).getText().equals("Instructors"));
//        assert (links.get(4).getText().contains("Students"));
//        assert (links.get(5).getText().equals("Government Employees"));
//        assert (links.get(6).getText().equals("Societies"));
//        assert (links.get(7).getText().equals("Corporate Partners"));
        for (int i = 0; i < links.size(); i++) {
            String actualTitle = links.get(i).findElement(By.cssSelector("*")).getText();
            assert (LINK_TITLES.get(i).equals(actualTitle));
        }
        assert (links.size() == 8);
    }

    private WebElement getStudentsElement() {
        return driver.findElement(STUDENTS_LOCATOR);
    }


    private void getPageByURL(String url) {
        driver.get(url);
    }
}


