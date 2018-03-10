package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by steve on 10/03/18.
 */
public class PocTest {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void simpleTest() {
        driver.get("http://www.bbc.co.uk");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("BBC - Home"));
    }
}
