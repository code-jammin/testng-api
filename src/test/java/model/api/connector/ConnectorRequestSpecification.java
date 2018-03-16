package model.api.connector;

import java.util.Map;

/**
 * A POJO to represent a request specification.
 */
public class ConnectorRequestSpecification {
    private final String body;
    private final Map<String, String> headers;
    private final Map<String, String> queryParameters;

    public ConnectorRequestSpecification(String body, Map<String, String> headers, Map<String, String> queryParameters) {
        this.body = body;
        this.headers = headers;
        this.queryParameters = queryParameters;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }
}
