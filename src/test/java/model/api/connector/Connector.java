package model.api.connector;

/**
 * A base connector class. Connectors are wrappers for API calls.
 *
 * @author steve
 */
interface Connector {
    ConnectorResponse execute();
}
