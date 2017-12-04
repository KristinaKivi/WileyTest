package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Check_Resources_subheader extends BaseTest {

    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final List<String> LINK_TITLES = Arrays.asList ("Students","Authors","Instructors","Librarians","Societies","Conferences","Booksellers","Corporations","Institutions");

    @Test
    public void search_resourses() {
        getPageByURL(WILEY_URL);
        List<WebElement> links = driver.findElement(By.cssSelector(".fe_resource_link.subjects-hoverlist")).findElements(By.cssSelector("li"));
        Assert.assertTrue (links.size() == 9);
        for (int i = 0; i < links.size(); i++) {
            String actualTitle = links.get(i).findElement(By.cssSelector("*")).getText();
            Assert.assertTrue(LINK_TITLES.get(i).equals(actualTitle));
        }
    }
        private void getPageByURL(String url) {
            driver.get(url);
        }
    }
