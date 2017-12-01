package functional.tests.Kristina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");

        driver = new ChromeDriver(options);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}