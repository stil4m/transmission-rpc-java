package nl.stil4m.transmission.http;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestExecutor {

    private final ObjectMapper objectMapper;
    private final HostConfiguration hostConfiguration;
    private final HttpClient httpClient;
    private final Map<String, String> headers;

    public RequestExecutor(ObjectMapper objectMapper, HostConfiguration hostConfiguration, HttpClient httpClient) {
        this.objectMapper = objectMapper;
        this.hostConfiguration = hostConfiguration;
        this.httpClient = httpClient;
        this.headers = new HashMap<>();
    }

    public void configureHeader(String name, String value) {
        headers.put(name, value);
    }

    public void removeHeader(String name) {
        headers.remove(name);
    }

    public <T, V> V execute(T payLoad, Class<V> responseClazz, int expectedStatusCode) throws RequestExecutorException, InvalidResponseStatus {
        try {
            HttpPost httpPost = createPost();

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }

            String value = objectMapper.writeValueAsString(payLoad);
            httpPost.setEntity(new StringEntity(value, "UTF-8"));

            HttpResponse result = httpClient.execute(httpPost);
            if (result.getStatusLine().getStatusCode() != expectedStatusCode) {
                int statusCode = result.getStatusLine().getStatusCode();
                EntityUtils.consume(result.getEntity());
                throw new InvalidResponseStatus(statusCode);
            }
            V v = objectMapper.readValue(result.getEntity().getContent(), responseClazz);
            EntityUtils.consume(result.getEntity());
            return v;
        } catch (IOException e) {
            throw new RequestExecutorException(e);
        }
    }

    protected HttpPost createPost() {
        return new HttpPost(hostConfiguration.getHost());
    }

    public void removeAllHeaders() {
        headers.clear();
    }
}
