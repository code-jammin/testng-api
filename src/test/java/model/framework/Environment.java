package model.framework;

/**
 * An interface for the test environment
 *
 * @author steve
 */
public interface Environment {
    public String getExternalApiHost();

    public String getPortalBaseUrl();

    public void logValues();
}
