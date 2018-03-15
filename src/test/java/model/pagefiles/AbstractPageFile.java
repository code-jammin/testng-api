package model.pagefiles;

import model.framework.Environment;
import org.openqa.selenium.WebDriver;

/**
 * The abstract page file that carries out generic web driver functions.
 *
 * @author steve
 */
public abstract class AbstractPageFile {

    private final WebDriver driver;
    private final Environment environment;

    public AbstractPageFile(WebDriver driver, Environment environment) {
        this.driver = driver;
        this.environment = environment;
    }

    public abstract String getUrl();

    public void load() {
        driver.get(getUrl());
    }

    protected Environment getEnvironment() {
        return environment;
    }

}
