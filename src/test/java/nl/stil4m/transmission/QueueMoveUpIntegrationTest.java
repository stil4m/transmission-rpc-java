package nl.stil4m.transmission;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.stil4m.transmission.api.TransmissionRpcClient;
import nl.stil4m.transmission.api.domain.AddTorrentInfo;
import nl.stil4m.transmission.api.domain.QueueAction;
import nl.stil4m.transmission.api.domain.RemoveTorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentInfo;
import nl.stil4m.transmission.api.domain.TorrentInfoCollection;
import nl.stil4m.transmission.api.domain.ids.NumberListIds;
import nl.stil4m.transmission.api.domain.ids.OmittedIds;
import nl.stil4m.transmission.api.torrent.TorrentStatus;
import nl.stil4m.transmission.rpc.RpcClient;
import nl.stil4m.transmission.rpc.RpcConfiguration;
import nl.stil4m.transmission.rpc.RpcException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueMoveUpIntegrationTest extends IntegrationTest {

    private TransmissionRpcClient rpcClient;
    private TorrentInfo torrent;
    private TorrentInfo secondTorrent;
    private TorrentInfo thirdTorrent;

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

        AddTorrentInfo addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo
                .setFilename("magnet:?xt=urn:btih:727665E0FE70263CD0B715758C2E8DB9A78554EC&dn=white+house+down+2013+720p+brrip+x264+yify&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(true);
        rpcClient.addTorrent(addTorrentInfo);

        addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo
                .setFilename("magnet:?xt=urn:btih:4F178D9782845F20714E5D8B5E05EF68A77E54F9&dn=pacific+rim+2013+1080p+brrip+x264+yify&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(false);
        rpcClient.addTorrent(addTorrentInfo);

        addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo
                .setFilename("magnet:?xt=urn:btih:5227055BEEFB753740AE102999842035F2942FEB&dn=man+of+steel+2013+bdrip+x264+larceny&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337");
        addTorrentInfo.setPaused(true);
        rpcClient.addTorrent(addTorrentInfo);

        result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().size(), is(3));

        torrent = result.getTorrents().get(0);
        secondTorrent = result.getTorrents().get(1);
        thirdTorrent = result.getTorrents().get(2);

        assertThat(torrent.getStatus(), is(TorrentStatus.STOPPED.getValue()));
        assertThat(secondTorrent.getStatus(), is(TorrentStatus.DOWNLOADING.getValue()));
        pause();
    }

    @After
    public void after() throws RpcException, InterruptedException {
        pause();
        rpcClient.removeTorrent(new RemoveTorrentInfo(new OmittedIds(), true));
    }

    @Test
    public void moveBottomOneUp() throws RpcException {
        rpcClient.doQueueAction(QueueAction.MOVE_UP, new NumberListIds(thirdTorrent.getId()));
        pause();

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().get(0).getId(), is(torrent.getId()));
        assertThat(result.getTorrents().get(0).getQueuePosition(), is(0L));

        assertThat(result.getTorrents().get(1).getId(), is(secondTorrent.getId()));
        assertThat(result.getTorrents().get(1).getQueuePosition(), is(2L));

        assertThat(result.getTorrents().get(2).getId(), is(thirdTorrent.getId()));
        assertThat(result.getTorrents().get(2).getQueuePosition(), is(1L));
    }

    @Test
    public void moveTopOneDown() throws RpcException {
        rpcClient.doQueueAction(QueueAction.MOVE_DOWN, new NumberListIds(torrent.getId()));
        pause();

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().get(0).getId(), is(torrent.getId()));
        assertThat(result.getTorrents().get(0).getQueuePosition(), is(1L));

        assertThat(result.getTorrents().get(1).getId(), is(secondTorrent.getId()));
        assertThat(result.getTorrents().get(1).getQueuePosition(), is(0L));

        assertThat(result.getTorrents().get(2).getId(), is(thirdTorrent.getId()));
        assertThat(result.getTorrents().get(2).getQueuePosition(), is(2L));
    }

    @Test
    public void moveTopToBottom() throws RpcException {
        rpcClient.doQueueAction(QueueAction.MOVE_BOTTOM, new NumberListIds(torrent.getId()));
        pause();

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().get(0).getId(), is(torrent.getId()));
        assertThat(result.getTorrents().get(0).getQueuePosition(), is(2L));

        assertThat(result.getTorrents().get(1).getId(), is(secondTorrent.getId()));
        assertThat(result.getTorrents().get(1).getQueuePosition(), is(0L));

        assertThat(result.getTorrents().get(2).getId(), is(thirdTorrent.getId()));
        assertThat(result.getTorrents().get(2).getQueuePosition(), is(1L));
    }

    @Test
    public void moveBottomToTop() throws RpcException {
        rpcClient.doQueueAction(QueueAction.MOVE_TOP, new NumberListIds(thirdTorrent.getId()));
        pause();

        TorrentInfoCollection result = rpcClient.getAllTorrentsInfo();
        assertThat(result.getTorrents().get(0).getId(), is(torrent.getId()));
        assertThat(result.getTorrents().get(0).getQueuePosition(), is(1L));

        assertThat(result.getTorrents().get(1).getId(), is(secondTorrent.getId()));
        assertThat(result.getTorrents().get(1).getQueuePosition(), is(2L));

        assertThat(result.getTorrents().get(2).getId(), is(thirdTorrent.getId()));
        assertThat(result.getTorrents().get(2).getQueuePosition(), is(0L));
    }

}