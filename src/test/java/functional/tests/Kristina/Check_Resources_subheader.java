package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class Check_Resources_subheader extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";


    @Test
    public void search_resourses() {
        getPageByURL(WILEY_URL);
        List<WebElement> links = driver.findElement(By.cssSelector(".fe_resource_link.subjects-hoverlist")).findElements(By.cssSelector("li"));
        assert (links.size() == 9);
        assert (links.get(0).getText().equals("Students"));
        assert (links.get(1).getText().equals("Authors"));
        assert (links.get(2).getText().equals("Instructors"));
        assert (links.get(3).getText().equals("Librarians"));
        assert (links.get(4).getText().equals("Societies"));
        assert (links.get(5).getText().equals("Conferences"));
        assert (links.get(6).getText().equals("Booksellers"));
        assert (links.get(7).getText().equals("Corporations"));
        assert (links.get(8).getText().equals("Institutions"));
    }

    private void getPageByURL(String url) {
        driver.get(url);
    }
}

