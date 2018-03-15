package model.api.connector;

import model.framework.Environment;
import okhttp3.OkHttpClient;

/**
 * Created by steve on 13/03/18.
 */
public abstract class AbstractConnector implements Connector {
    protected final Environment environment;
    protected final OkHttpClient httpClient;

    public AbstractConnector(Environment environment, OkHttpClient httpClient) {
        this.environment = environment;
        this.httpClient = httpClient;
    }
}
