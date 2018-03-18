package model.framework;

import model.api.connector.WordCheckConnector;

/**
 * A POJO containing connectors.
 *
 * @author steve
 */
public class Connectors {
    private final Environment environment;

    private WordCheckConnector wordCheckConnector;

    public Connectors(Environment environment) {
        this.environment = environment;
        initializeConnectors();
    }

    public WordCheckConnector wordCheckConnector() {
        return wordCheckConnector;
    }

    private void initializeConnectors() {
        wordCheckConnector = new WordCheckConnector(environment);
    }
}
