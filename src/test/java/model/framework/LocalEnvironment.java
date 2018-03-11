package model.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hard coded environmental information for a local environment
 *
 * @author steve
 */
public class LocalEnvironment implements Environment {
    private static final Logger LOG = LoggerFactory.getLogger(LocalEnvironment.class);

    private static final String EXTERNAL_API_HOST = "http://localhost:8082";
    private static final String PORTAL_BASE_URL = "http://www.bbc.co.uk";

    public LocalEnvironment() {
        LOG.info("Initialising environment");
    }

    @Override
    public String getExternalApiHost() {
        return EXTERNAL_API_HOST;
    }

    @Override
    public String getPortalBaseUrl() {
        return PORTAL_BASE_URL;
    }

    @Override
    public void logValues() {
        LOG.info("External API Host: " + EXTERNAL_API_HOST);
        LOG.info("Portal Base URL: " + PORTAL_BASE_URL);
    }
}
