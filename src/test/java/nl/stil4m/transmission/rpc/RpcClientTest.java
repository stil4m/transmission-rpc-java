package nl.stil4m.transmission.rpc;

import com.google.common.io.Files;

import nl.stil4m.transmission.api.TransmissionRpcClient;
import nl.stil4m.transmission.api.commands.AddTorrentCommand;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.net.URI;

public class RpcClientTest {

    @Test
    public void testSessionStats() throws RpcException {
        RpcConfiguration configuration = new RpcConfiguration();
        configuration.setHost(URI.create("http://localhost:9091/transmission/rpc"));
        TransmissionRpcClient rpcClient = new TransmissionRpcClient(configuration, new ObjectMapper());
        rpcClient.setup();

        File tempDir = Files.createTempDir();
//        AddTorrentCommand result = rpcClient.addTorrent(tempDir.getAbsolutePath(), "magnet:?xt=urn:btih:1c3d3743dcb8f1d438d71fdc3137e0b79aaa4209&dn=The+Incredible+Burt+Wonderstone+2013+HDRip+XviD+READNFO-playXD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80");

        System.out.println("");
    }
}
