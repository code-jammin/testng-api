package model.framework;

import model.pagefiles.LandingPage;
import org.openqa.selenium.WebDriver;

/**
 * A factory class for producing page files
 */
public class PageFactory {
    private final WebDriver driver;
    private final Environment environment;


    private LandingPage landingPage;

    public PageFactory(WebDriver driver, Environment environment) {
        this.driver = driver;
        this.environment = environment;
        landingPage = new LandingPage(driver, environment);
    }

    public LandingPage landingPage() {
        return landingPage;
    }
}
