package model.framework;

import model.pagefiles.LandingPage;
import org.openqa.selenium.WebDriver;

/**
 * A POJO containing page files
 *
 * @author steve
 */
public class Pages {
    private final WebDriver driver;
    private final Environment environment;

    private LandingPage landingPage;

    public Pages(WebDriver driver, Environment environment) {
        this.driver = driver;
        this.environment = environment;

        landingPage = new LandingPage(driver, environment);
    }

    public LandingPage landingPage() {
        return landingPage;
    }
}
