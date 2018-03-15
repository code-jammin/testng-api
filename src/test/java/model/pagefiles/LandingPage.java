package model.pagefiles;

import model.framework.Environment;
import org.openqa.selenium.WebDriver;

/**
 * A page file representing the landing page of the website.
 *
 * @author steve
 */
public class LandingPage extends AbstractPageFile {

    public LandingPage(WebDriver driver, Environment environment) {
        super(driver, environment);
    }

    public String getUrl() {
        return getEnvironment().getPortalBaseUrl();
    }
}
