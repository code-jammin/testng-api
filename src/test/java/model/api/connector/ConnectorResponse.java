package model.api.connector;

import java.util.List;
import java.util.Map;

/**
 * A POJO to represent the response from a connector
 *
 * @author steve
 */
public class ConnectorResponse {
    private final String responseBody;
    private final int status;
    private final Map<String, List<String>> headers;

    public ConnectorResponse(String responseBody, int status, Map<String, List<String>> headers) {
        this.responseBody = responseBody;
        this.status = status;
        this.headers = headers;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}
