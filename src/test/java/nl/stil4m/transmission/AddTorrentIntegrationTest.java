package nl.stil4m.transmission;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.stil4m.transmission.api.TransmissionRpcClient;
import nl.stil4m.transmission.api.domain.AddTorrentInfo;
import nl.stil4m.transmission.api.domain.AddedTorrentInfo;
import nl.stil4m.transmission.api.domain.RemoveTorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentInfoCollection;
import nl.stil4m.transmission.api.domain.ids.OmittedIds;
import nl.stil4m.transmission.rpc.RpcClient;
import nl.stil4m.transmission.rpc.RpcConfiguration;
import nl.stil4m.transmission.rpc.RpcException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTorrentIntegrationTest extends IntegrationTest {

    private TransmissionRpcClient rpcClient;

    @Before
    public void before() throws RpcException, MalformedURLException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        RpcConfiguration rpcConfiguration = new RpcConfiguration();
        rpcConfiguration.setHost(URI.create("http://localhost:9091/transmission/rpc"));
        RpcClient client = new RpcClient(rpcConfiguration, objectMapper);
        rpcClient = new TransmissionRpcClient(client);
        rpcClient.removeTorrent(new RemoveTorrentInfo(new OmittedIds(), true));
        pause();
        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().size(), is(0));
    }

    @After
    public void after() throws RpcException, InterruptedException {
        pause();
        rpcClient.removeTorrent(new RemoveTorrentInfo(new OmittedIds(), true));
    }

    @Test
    public void testAddTorrent() throws RpcException {
        AddTorrentInfo addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo
                .setFilename("magnet:?xt=urn:btih:727665E0FE70263CD0B715758C2E8DB9A78554EC&dn=white+house+down+2013+720p+brrip+x264+yify&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(true);
        AddedTorrentInfo result = rpcClient.addTorrent(addTorrentInfo);
        TorrentInfo info = result.getTorrentInfo();

        assertThat(info, is(notNullValue()));
        assertThat(info.getId(), is(notNullValue()));
        assertThat(info.getName(), is("white+house+down+2013+720p+brrip+x264+yify"));
    }
}
