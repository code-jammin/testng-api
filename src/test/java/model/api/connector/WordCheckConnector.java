package model.api.connector;

import model.framework.Environment;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The connector for the word check endpoint
 *
 * @author steve
 */
public class WordCheckConnector extends AbstractConnector {

    private static final String PROFANITY_RESOURCE = "profanity";
    private static final String CHECK_RESOURCE = "check";
    private static final String TEXT_QUERY_PARAMETER = "text";

    public WordCheckConnector(Environment environment) {
        super(environment);
    }

    public ConnectorResponse execute(ConnectorRequestSpecification requestSpecification) throws IOException{
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(getEnvironment().getExternalApiHost())
                .port(getEnvironment().getExternalApiPort())
                .addPathSegment(PROFANITY_RESOURCE)
                .addPathSegment(CHECK_RESOURCE)
                .addQueryParameter(TEXT_QUERY_PARAMETER, requestSpecification.getQueryParameters().get(TEXT_QUERY_PARAMETER))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = getHttpClient().newCall(request).execute();

        return new ConnectorResponse(response.body().string(), response.code(), response.headers().toMultimap());
    }

    /**
     * Convenience method to handle setting up the request specification, simply to perform a word check on the provided
     * string.
     *
     * @param textToCheck the text to check
     * @return an executed response object
     * @throws IOException
     */
    public ConnectorResponse executeSimpleCall(String textToCheck)  throws IOException {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("text", textToCheck);

        ConnectorRequestSpecification requestSpecification = ConnectorRequestSpecification.builder()
                .withQueryParameters(queryParams)
                .build();

        return execute(requestSpecification);
    }

}
