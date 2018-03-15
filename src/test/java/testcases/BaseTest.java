package testcases;

import model.framework.Environment;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * A base test class to manage core constructs and ensure all tests start up and tear down correctly
 *
 * @author steve
 */
public abstract class BaseTest {
    protected final static Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    private Environment environment;

    /**
     * Convenience method that assigns the environment to a field
     *
     * @param context the current context for the test
     */
    @BeforeMethod(alwaysRun = true)
    protected void setEnvironment(ITestContext context) {
        environment = (Environment) context.getAttribute("environment");
        if (environment == null) {
            Assert.assertNotNull(environment, "The environment is null, it has not been added to the ITestContext correctly.");
        }
    }

    /**
     * Tear down current test capabilities after a test finishes
     *
     * @param context the current test context
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestContext context) {
        WebDriver driver = getDriverFromContext(context);
        if(driver != null) {
            LOG.info("Shutting down WebDriver");
            driver.quit();
        }
    }

    /**
     * Getter for the environment
     *
     * @return the current environment
     */
    protected Environment getEnvironment() {
        if (environment == null) {
            Assert.assertNotNull(environment, "The environment is null, make sure it is getting set correctly.");
        }
        return environment;
    }

    /**
     * Attempts to fetch the driver from the context
     *
     * @param context the ITestContext for the current test
     * @return WebDriver from the ITestContext
     */
    private WebDriver getDriverFromContext(ITestContext context) {
        return (WebDriver) context.getAttribute("driver");
    }
}
