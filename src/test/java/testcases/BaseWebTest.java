package testcases;

import model.framework.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

/**
 * A base web test to manage core aspects of a web test.
 *
 * @author steve
 */
public abstract class BaseWebTest extends BaseTest {
    private WebDriver driver;
    private Pages pages;

    /**
     * Sets up the pages object
     *
     * @param context the ITestContext
     */
    @BeforeMethod(alwaysRun = true)
    protected void setPages(ITestContext context) {
        LOG.info("Initialising WebDriver");
        driver = new FirefoxDriver();
        LOG.info("WebDriver initialised, adding to ITestContext");
        context.setAttribute("driver", driver);

        LOG.info("Initialising pages");
        pages = new Pages(driver, getEnvironment());
    }

    /**
     * @return the page models
     */
    protected Pages pages() {
        if (pages == null) {
            Assert.assertNotNull(pages, "The pages is null, check whether it was initialised");
        }
        return pages;
    }


}
