package nl.stil4m.transmission.api;

import com.google.common.collect.Lists;

import nl.stil4m.transmission.api.commands.*;
import nl.stil4m.transmission.api.domain.*;
import nl.stil4m.transmission.api.domain.ids.Ids;
import nl.stil4m.transmission.api.domain.ids.NumberListIds;
import nl.stil4m.transmission.api.domain.ids.OmittedIds;
import nl.stil4m.transmission.rpc.RpcClient;
import nl.stil4m.transmission.rpc.RpcConfiguration;
import nl.stil4m.transmission.rpc.RpcException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class TransmissionRpcClient extends RpcClient {

    private static final List<String> torrentInfoFields = Lists.newArrayList(
            "activityDate", "addedDate", "bandwidthPriority", "comment", "corruptEver", "creator", "dateCreated", "desiredAvailable", "doneDate", "downloadDir", "downloadedEver", "downloadLimit", "downloadLimited", "error", "errorString", "eta", "etaIdle", "files", "fileStats", "hashString", "haveUnchecked", "haveValid", "honorsSessionLimits", "id", "isFinished", "isPrivate", "isStalled", "leftUntilDone", "magnetLink", "manualAnnounceTime", "maxConnectedPeers", "metadataPercentComplete", "name", "peer-limit", "peers", "peersConnected", "peersFrom", "peersGettingFromUs", "peersSendingToUs", "percentDone", "pieces", "pieceCount", "pieceSize", "priorities", "queuePosition", "rateDownload (B/s)", "rateUpload (B/s)", "recheckProgress", "secondsDownloading", "secondsSeeding", "seedIdleLimit", "seedIdleMode", "seedRatioLimit", "seedRatioMode", "sizeWhenDone", "startDate", "status", "trackers", "trackerStats", "totalSize", "torrentFile", "uploadedEver", "uploadLimit", "uploadLimited", "uploadRatio", "wanted", "webseeds", "webseedsSendingToUs"
    );


    public TransmissionRpcClient(RpcConfiguration configuration) {
        super(configuration);

    }

    public SessionStatsCommand getSessionStats() throws RpcException {
        SessionStatsCommand command = new SessionStatsCommand(nextTag());
        executeWithHeaders(command);
        return command;
    }

    public void setup() throws RpcException {
        try {
            DefaultHttpClient defaultHttpClient = getClient();
            HttpPost httpPost = createPost();
            HttpResponse result = defaultHttpClient.execute(httpPost);
            putHeader(result);
            EntityUtils.consume(result.getEntity());
        } catch (IOException e) {
            throw new RpcException(e);
        }
    }

    public TorrentGetCommand getTorrentsInfo() throws RpcException {
        return getTorrentsInfo(null, torrentInfoFields);
    }

    public TorrentGetCommand getTorrentInfo(Long torrentId) throws RpcException {
        return getTorrentsInfo(Lists.newArrayList(torrentId), torrentInfoFields);
    }

    public TorrentGetCommand getTorrentsInfo(List<Long> ids, List<String> fields) throws RpcException {
        TorrentGetCommand torrentGetCommand = new TorrentGetCommand(nextTag());
        TorrentGetRequestInfo torrentGetRequestInfo = new TorrentGetRequestInfo();
        torrentGetRequestInfo.setFields(fields);
        torrentGetRequestInfo.setIds(ids);
        torrentGetCommand.setRequestArguments(torrentGetRequestInfo);
        executeWithHeaders(torrentGetCommand);
        return torrentGetCommand;
    }

    private TorrentActionCommand doTorrentAction(TorrentAction torrentAction, Ids ids) throws RpcException {
        TorrentActionCommand torrentActionCommand = new TorrentActionCommand(nextTag(), torrentAction);
        torrentActionCommand .setRequestArguments(ids);
        executeWithHeaders(torrentActionCommand);
        return torrentActionCommand;
    }
    public TorrentActionCommand doOnAllTorrents(TorrentAction torrentAction) throws RpcException {
        return doTorrentAction(torrentAction, new OmittedIds());
    }

    public TorrentActionCommand doOnTorrents(TorrentAction torrentAction, List<Long> ids) throws RpcException {
        return doTorrentAction(torrentAction, new NumberListIds(Lists.newArrayList(ids)));
    }

    public TorrentActionCommand doOnTorrent(TorrentAction torrentAction, Long id) throws RpcException {
        return doOnTorrents(torrentAction, Lists.newArrayList(id));
    }

    public AddTorrentCommand addTorrent(String target, String location) throws RpcException {
        AddTorrentInfo addTorrentInfo = new AddTorrentInfo();
        addTorrentInfo.setFilename(location);
        addTorrentInfo.setDownloadDir(target);
        AddTorrentCommand addTorrentCommand = new AddTorrentCommand(nextTag());
        addTorrentCommand.setRequestArguments(addTorrentInfo);
        executeWithHeaders(addTorrentCommand);
        return addTorrentCommand;
    }

    public RemoveTorentCommand removeTorrent(Long id, boolean deleteData) throws RpcException {
        RemoveTorrentInfo removeTorrentInfo = new RemoveTorrentInfo(new NumberListIds(Lists.newArrayList(id)), deleteData);
        RemoveTorentCommand removeTorentCommand = new RemoveTorentCommand(nextTag());
        removeTorentCommand.setRequestArguments(removeTorrentInfo);
        executeWithHeaders(removeTorentCommand);
        return removeTorentCommand;
    }
}
