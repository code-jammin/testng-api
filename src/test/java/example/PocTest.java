package example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import annotations.BrowserTest;

/**
 * Proof of concept test steps
 *
 * @author steve
 */
public class PocTest {
    @Test
    @BrowserTest
    public void simpleTest(ITestContext context) {
        ((WebDriver) context.getAttribute("driver")).get("http://www.bbc.co.uk");
        String title = ((WebDriver) context.getAttribute("driver")).getTitle();
        Assert.assertTrue(title.contains("BBC - Home"));
    }

    @Test
    @BrowserTest
    public void duplicateOfSimpleTest(ITestContext context) {
        ((WebDriver) context.getAttribute("driver")).get("http://www.bbc.co.uk");
        String title = ((WebDriver) context.getAttribute("driver")).getTitle();
        Assert.assertTrue(title.contains("BBC - Home"));
    }

    @Test
    public void aTestThatDoesntUseSeleneium() {
        Assert.assertTrue(true);
    }

    @Test
    public void aTestThatDoesntUseSeleniumAlsoFails() {
        Assert.assertTrue(false);
    }

}
