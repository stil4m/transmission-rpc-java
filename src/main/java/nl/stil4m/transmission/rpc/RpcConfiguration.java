package nl.stil4m.transmission.rpc;

import nl.stil4m.transmission.http.HostConfiguration;

import java.net.URI;

public class RpcConfiguration implements HostConfiguration {

    private URI host;

    public URI getHost() {
        return host;
    }

    public void setHost(URI host) {
        this.host = host;
    }
}
