package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Operations pertaining to the configuration of tests
 *
 * @author steve
 */
public class TestConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(TestConfiguration.class);

    @BeforeSuite(alwaysRun = true)
    public static void setupClass() {
        LOG.info("Configuring WebDriver binaries");
        WebDriverManager.firefoxdriver().setup();
    }

    @AfterMethod
    public void afterTest(ITestContext context) {
        WebDriver driver = ((WebDriver) context.getAttribute("driver"));
        if(driver != null) {
            LOG.info("Shutting down WebDriver");
            driver.quit();
        }
    }
}
