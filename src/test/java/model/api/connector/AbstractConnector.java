package model.api.connector;

import model.framework.Environment;
import okhttp3.OkHttpClient;

/**
 * The abstract class for an API endpoint connector.
 *
 * @author steve
 */
public abstract class AbstractConnector implements Connector {
    private final Environment environment;
    private final OkHttpClient httpClient;

    public AbstractConnector(Environment environment) {
        this.environment = environment;
        httpClient = new OkHttpClient();
    }

    public Environment getEnvironment() {
        return environment;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }
}
