package model.api.connector;

import model.framework.Environment;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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


}
