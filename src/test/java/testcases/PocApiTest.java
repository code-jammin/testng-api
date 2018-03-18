package testcases;

import model.api.connector.ConnectorResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * A proof of concept API test class.
 *
 * @author steve
 */
public class PocApiTest extends BaseApiTest {

    @Test
    public void testThatSendingProfanityReturnsTrue() throws IOException {
        ConnectorResponse response = connectors().wordCheckConnector().executeSimpleCall("fuck shit");

        Assert.assertEquals(200, response.getStatus(), "Status code was not the expected value");
        Assert.assertTrue("true".contains(response.getResponseBody()));
    }

    @Test
    public void testThatCleanStringReturnsFalse() throws IOException {
        ConnectorResponse response = connectors().wordCheckConnector().executeSimpleCall("purple bananas");

        Assert.assertEquals(200, response.getStatus(), "Status code was not the expected value");
        Assert.assertTrue("false".contains(response.getResponseBody()));
    }
}
