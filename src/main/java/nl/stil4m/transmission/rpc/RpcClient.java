package nl.stil4m.transmission.rpc;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.TypeReference;

import java.util.HashMap;
import java.util.Map;

public class RpcClient {

    private final RpcConfiguration configuration;
    private final ObjectMapper objectMapper;
    private final Map<String, String> headers;
    private final DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

    private final TagProvider tagProvider = new TagProvider();

    public RpcClient(RpcConfiguration configuration) {
        this.configuration = configuration;
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        headers = new HashMap<String, String>();
    }

    public <T, V> void execute(RpcCommand<T, V> command, Map<String, String> h) throws RpcException {
        try {
            HttpPost httpPost = createPost();

            for (Map.Entry<String, String> entry : h.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }

            RpcRequest<T> request = command.buildRequestPayload();
            String value = objectMapper.writeValueAsString(request);
            httpPost.setEntity(new StringEntity(value, "UTF-8"));

            HttpResponse result = defaultHttpClient.execute(httpPost);

            String responseString = IOUtils.toString(result.getEntity().getContent());
            EntityUtils.consume(result.getEntity());

            RpcResponse<V> response = objectMapper.readValue(responseString, new TypeReference<RpcResponse<V>>() {
            });
            Map args = (Map) response.getArguments();
            response.setArguments((V) objectMapper.readValue(objectMapper.writeValueAsString(args), command.getArgumentsObject()));
            command.setResponse(response);

            if (!"success".equals(response.getResult())) {
                throw new RpcException("Rpc Command Failed", response.getResult(), command);
            }
        } catch (Exception e) {
            throw new RpcException(e);
        }
    }

    public void setup() throws RpcException {
        //NO-OP
    }

    protected HttpPost createPost() {
        return new HttpPost(configuration.getHost());
    }

    protected DefaultHttpClient getClient() {
        return defaultHttpClient;
    }

    protected void executeWithHeaders(RpcCommand command) throws RpcException {
        execute(command, headers);
    }

    protected void putHeader(HttpResponse result) {
        headers.put("X-Transmission-Session-Id", result.getFirstHeader("X-Transmission-Session-Id").getValue());
    }

    protected Long nextTag() {
        return tagProvider.nextTag();
    }
}
