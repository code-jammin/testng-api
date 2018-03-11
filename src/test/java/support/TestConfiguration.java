package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.framework.Environment;
import model.framework.LocalEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
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

    @BeforeSuite(alwaysRun = true)
    public static void setupEnvironment(ITestContext context) {
        LOG.info("Configuring Environment");
        Environment environment = new LocalEnvironment(); //TODO refactor this so I use a profile to drive environment
        environment.logValues();
        LOG.info("Adding Environment to ITestContext");
        context.setAttribute("environment", environment);
    }
}
