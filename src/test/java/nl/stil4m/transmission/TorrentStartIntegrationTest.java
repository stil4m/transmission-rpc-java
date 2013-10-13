package nl.stil4m.transmission;

import nl.stil4m.transmission.api.TransmissionRpcClient;
import nl.stil4m.transmission.api.domain.AddTorrentInfo;
import nl.stil4m.transmission.api.domain.RemoveTorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentAction;
import nl.stil4m.transmission.api.domain.TorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentInfoCollection;
import nl.stil4m.transmission.api.domain.ids.NumberListIds;
import nl.stil4m.transmission.api.domain.ids.OmittedIds;
import nl.stil4m.transmission.api.domain.ids.ShaListIds;
import nl.stil4m.transmission.api.torrent.TorrentStatus;
import nl.stil4m.transmission.rpc.RpcClient;
import nl.stil4m.transmission.rpc.RpcConfiguration;
import nl.stil4m.transmission.rpc.RpcException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TorrentStartIntegrationTest extends IntegrationTest {

    private TransmissionRpcClient rpcClient;

    private TorrentInfo torrent;

    @Before
    public void before() throws RpcException, MalformedURLException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        RpcConfiguration rpcConfiguration = new RpcConfiguration();
        rpcConfiguration.setHost(URI.create("http://localhost:9091/transmission/rpc"));
        RpcClient client = new RpcClient(rpcConfiguration, objectMapper);
        rpcClient = new TransmissionRpcClient(client);
        rpcClient.removeTorrent(new RemoveTorrentInfo(new OmittedIds(), true));
        pause();
        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().size(), is(0));

        AddTorrentInfo addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo.setFilename("magnet:?xt=urn:btih:727665E0FE70263CD0B715758C2E8DB9A78554EC&dn=white+house+down+2013+720p+brrip+x264+yify&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(true);
        rpcClient.addTorrent(addTorrentInfo);

        addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo.setFilename("magnet:?xt=urn:btih:4F178D9782845F20714E5D8B5E05EF68A77E54F9&dn=pacific+rim+2013+1080p+brrip+x264+yify&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(true);
        rpcClient.addTorrent(addTorrentInfo);


        result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().size(), is(2));

        torrent = result.getTorrents().get(0);
        TorrentInfo secondTorrent = result.getTorrents().get(1);
        assertThat(torrent.getStatus(), is(TorrentStatus.PAUSED));
        assertThat(secondTorrent.getStatus(), is(TorrentStatus.PAUSED));
        pause();
    }

    @After
    public void after() throws RpcException, InterruptedException {
        pause();
        rpcClient.removeTorrent(new RemoveTorrentInfo(new OmittedIds(), true));
    }

    @Test
    public void testStartTorrentWithTorrentId() throws RpcException {
        rpcClient.doAction(new NumberListIds(torrent.getId()), TorrentAction.START);

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        TorrentInfo torrentInfo = result.getTorrents().get(0);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.DOWNLOADING));

        torrentInfo = result.getTorrents().get(1);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.PAUSED));
    }

    @Test
    public void testStartTorrentWithTorrentHash() throws RpcException {
        rpcClient.doAction(new ShaListIds(torrent.getHashString()), TorrentAction.START);

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        TorrentInfo torrentInfo = result.getTorrents().get(0);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.DOWNLOADING));

        torrentInfo = result.getTorrents().get(1);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.PAUSED));
    }

    @Test
    public void testStartAllTorrents() throws RpcException {
        rpcClient.doAction(new OmittedIds(), TorrentAction.START);

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        TorrentInfo torrentInfo = result.getTorrents().get(0);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.DOWNLOADING));

        torrentInfo = result.getTorrents().get(1);
        assertThat(torrentInfo.getStatus(), is(TorrentStatus.DOWNLOADING));
    }

}
