package testcases;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import annotations.BrowserTest;

import java.io.IOException;

/**
 * Proof of concept test steps
 *
 * @author steve
 */
public class PocTest extends BaseTest {
    @Test
    @BrowserTest
    public void simpleTest(ITestContext context) {
        ((WebDriver) context.getAttribute("driver")).get(getEnvironment().getPortalBaseUrl());
        String title = ((WebDriver) context.getAttribute("driver")).getTitle();
        Assert.assertTrue(title.contains("BBC - Home"));
    }

    @Test
    @BrowserTest
    public void duplicateOfSimpleTest(ITestContext context) {
        ((WebDriver) context.getAttribute("driver")).get(getEnvironment().getPortalBaseUrl());
        String title = ((WebDriver) context.getAttribute("driver")).getTitle();
        Assert.assertTrue(title.contains("BBC - Home"));
    }

    @Test
    public void apiTest(ITestContext context) throws IOException {
        String response = get(getEnvironment().getExternalApiHost() + "/profanity/check?text=fuck shit");
        System.out.println("Response was: " + response);
    }

    private OkHttpClient client = new OkHttpClient();

    String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Test
    public void aTestThatDoesntUseSeleneium() {
        Assert.assertTrue(true);
    }

    @Test
    public void aTestThatDoesntUseSeleniumAlsoFails() {
        Assert.assertTrue(false);
    }

}
