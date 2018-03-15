package testcases;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Proof of concept test steps
 *
 * @author steve
 */
public class PocTest extends BaseTest {

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
