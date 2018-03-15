package model.api.connector;

/**
 * A POJO to represent the response from a connector
 *
 * @author steve
 */
public class ConnectorResponse {
    private final String responseBody;
    private final int status;

    public ConnectorResponse(String responseBody, int status) {
        this.responseBody = responseBody;
        this.status = status;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public int getStatus() {
        return status;
    }
}
