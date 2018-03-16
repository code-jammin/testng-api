package model.api.connector;

import java.io.IOException;

/**
 * A base connector class. Connectors are wrappers for API calls.
 *
 * @author steve
 */
interface Connector {
    ConnectorResponse execute(ConnectorRequestSpecification requestSpecification) throws IOException;
}
