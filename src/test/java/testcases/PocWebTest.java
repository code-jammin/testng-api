package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A proof of concept set of web tests.
 *
 * @author steve
 */
public class PocWebTest extends BaseWebTest {

    @Test
    public void pocWebTest() {
        pages().landingPage().load();
        Assert.assertTrue(pages().landingPage().getPageTitle().contains("BBC - Home"));
    }

    @Test
    public void pocWebTest2() {
        pages().landingPage().load();
        Assert.assertTrue(pages().landingPage().getPageTitle().contains("BBC - Home"));
    }

    @Test
    public void pocWebTest3() {
        pages().landingPage().load();
        Assert.assertTrue(pages().landingPage().getPageTitle().contains("BBC - Home"));
    }
}
