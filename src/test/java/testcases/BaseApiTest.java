package testcases;

import model.framework.Connectors;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

/**
 * A base API test class to manage core aspects of API tests
 *
 * @author steve
 */
public abstract class BaseApiTest extends BaseTest {
    private Connectors connectors;

    @BeforeMethod(alwaysRun = true)
    protected void setConnectors(ITestContext context) {
        LOG.info("Attempting to initialize connectors");
        connectors = new Connectors(getEnvironment());
    }

    /**
     * @return the connectors
     */
    protected Connectors connectors() {
        if (connectors == null) {
            Assert.assertNotNull(connectors, "The connectors object is null, check whether it was initialised");
        }
        return connectors;
    }

}
