package functional.tests.Kristina;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Check_Students_item extends BaseTest {


    private static final String WILEY_URL = "http://www.wiley.com/WileyCDA/";
    private static final By STUDENTS_LOCATOR = By.xpath("//a[text()='Students']");
    private static final int STUDENT_LINK_INDEX = 4;
    private static final String SPAN_TAG = "span";
    private static final String COLOR_BUTTON = "rgba(2, 95, 98, 1)";
    private static final By HOME_LOCATOR = By.xpath("//a[text()='Home']");


    @Test
    public void checkStudents() {
        getPageByURL(WILEY_URL);
        getStudentsElement().click();
        WebElement studentsButton = driver.findElements(By.cssSelector(".autonavLevel1 > li")).get(STUDENT_LINK_INDEX).findElement(By.cssSelector("span"));
        assert (studentsButton.getTagName().equals(SPAN_TAG));
        assert (studentsButton.getCssValue("color").equals(COLOR_BUTTON));
        getHomeElement().click();
    }

    private WebElement getHomeElement() {
        return driver.findElement(HOME_LOCATOR);
    }
    private WebElement getStudentsElement() {
        return driver.findElement(STUDENTS_LOCATOR);
    }


    private void getPageByURL(String url) {
        driver.get(url);
    }
}