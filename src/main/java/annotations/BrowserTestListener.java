package annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.lang.annotation.Annotation;

/**
 * A listener for the @BrowserTest annotation. It ensures that the web driver has been initialised and added to the
 * test context.
 *
 * @author steve
 */
public class BrowserTestListener implements IInvokedMethodListener2 {
    private static final Logger LOG = LoggerFactory.getLogger(BrowserTestListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        if(iInvokedMethod.isTestMethod() && isAnnotationPresent(iInvokedMethod, BrowserTest.class)) {
            LOG.info("Initialising WebDriver");
            WebDriver driver = new FirefoxDriver();
            LOG.info("WebDriver initialised, adding to ITestContext");
            iTestContext.setAttribute("driver", driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    private boolean isAnnotationPresent(IInvokedMethod method, Class<? extends Annotation> clazz) {
        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz);
    }
}
