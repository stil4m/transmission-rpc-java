package nl.stil4m.transmission.api;

import com.google.common.collect.Lists;

import nl.stil4m.transmission.api.commands.AddTorrentCommand;
import nl.stil4m.transmission.api.commands.RemoveTorentCommand;
import nl.stil4m.transmission.api.commands.SessionStatsCommand;
import nl.stil4m.transmission.api.commands.TorrentActionCommand;
import nl.stil4m.transmission.api.commands.TorrentGetCommand;
import nl.stil4m.transmission.api.domain.AddTorrentInfo;
import nl.stil4m.transmission.api.domain.AddedTorrentInfo;
import nl.stil4m.transmission.api.domain.RemoveTorrentInfo;
import nl.stil4m.transmission.api.domain.SessionStats;
import nl.stil4m.transmission.api.domain.TorrentAction;
import nl.stil4m.transmission.api.domain.TorrentGetRequestInfo;
import nl.stil4m.transmission.api.domain.TorrentInfoCollection;
import nl.stil4m.transmission.api.domain.ids.Ids;
import nl.stil4m.transmission.api.domain.ids.NumberListIds;
import nl.stil4m.transmission.api.domain.ids.ShaListIds;
import nl.stil4m.transmission.rpc.RpcClient;
import nl.stil4m.transmission.rpc.RpcCommand;
import nl.stil4m.transmission.rpc.RpcException;
import nl.stil4m.transmission.rpc.TagProvider;

import java.util.List;

public class TransmissionRpcClient {

    public static final List<String> torrentInfoFields = Lists.newArrayList(
            "activityDate", "addedDate", "bandwidthPriority", "comment", "corruptEver", "creator", "dateCreated", "desiredAvailable", "doneDate", "downloadDir", "downloadedEver", "downloadLimit", "downloadLimited", "error", "errorString", "eta", "etaIdle", "files", "fileStats", "hashString", "haveUnchecked", "haveValid", "honorsSessionLimits", "id", "isFinished", "isPrivate", "isStalled", "leftUntilDone", "magnetLink", "manualAnnounceTime", "maxConnectedPeers", "metadataPercentComplete", "name", "peer-limit", "peers", "peersConnected", "peersFrom", "peersGettingFromUs", "peersSendingToUs", "percentDone", "pieces", "pieceCount", "pieceSize", "priorities", "queuePosition", "rateDownload (B/s)", "rateUpload (B/s)", "recheckProgress", "secondsDownloading", "secondsSeeding", "seedIdleLimit", "seedIdleMode", "seedRatioLimit", "seedRatioMode", "sizeWhenDone", "startDate", "status", "trackers", "trackerStats", "totalSize", "torrentFile", "uploadedEver", "uploadLimit", "uploadLimited", "uploadRatio", "wanted", "webseeds", "webseedsSendingToUs"
    );

    private final RpcClient rpcClient;
    private final TagProvider tagProvider = new TagProvider();

    public TransmissionRpcClient(RpcClient rpcClient) {
        this.rpcClient = rpcClient;
    }

    public SessionStats getSessionStats() throws RpcException {
        SessionStatsCommand command = new SessionStatsCommand(nextTag());
        rpcClient.executeWithHeaders(command);
        return command.getResponse().getArguments();
    }

    public TorrentGetCommand getAllTorrentsInfo() throws RpcException {
        return getTorrentsInfo(null, torrentInfoFields);
    }

    public TorrentGetCommand getTorrentsInfo(List<String> ids) throws RpcException {
        return getTorrentsInfo(new ShaListIds(Lists.newArrayList(ids)), torrentInfoFields);
    }

    public TorrentGetCommand getTorrentInfo(Long torrentId) throws RpcException {
        return getTorrentsInfo(new NumberListIds(torrentId), torrentInfoFields);
    }

    public TorrentInfoCollection getTorrentInfo(TorrentGetRequestInfo torrentGetRequestInfo) throws RpcException {
        TorrentGetCommand torrentGetCommand = new TorrentGetCommand(nextTag());
        torrentGetCommand.setRequestArguments(torrentGetRequestInfo);
        rpcClient.executeWithHeaders(torrentGetCommand);
        return torrentGetCommand.getResponse().getArguments();
    }

    public TorrentGetCommand getTorrentsInfo(Ids ids, List<String> fields) throws RpcException {
        TorrentGetCommand torrentGetCommand = new TorrentGetCommand(nextTag());
        TorrentGetRequestInfo torrentGetRequestInfo = new TorrentGetRequestInfo(ids, fields);
        torrentGetCommand.setRequestArguments(torrentGetRequestInfo);
        rpcClient.executeWithHeaders(torrentGetCommand);
        return torrentGetCommand;
    }

    public AddedTorrentInfo addTorrent(AddTorrentInfo addTorrentInfo) throws RpcException {
        AddTorrentCommand addTorrentCommand = new AddTorrentCommand(nextTag());
        addTorrentCommand.setRequestArguments(addTorrentInfo);
        executeCommand(addTorrentCommand);
        return addTorrentCommand.getResponse().getArguments();
    }

    public void removeTorrent(RemoveTorrentInfo removeTorrentInfo) throws RpcException {
        RemoveTorentCommand removeTorentCommand = new RemoveTorentCommand(nextTag());
        removeTorentCommand.setRequestArguments(removeTorrentInfo);
        rpcClient.executeWithHeaders(removeTorentCommand);
    }

    public void doAction(Ids ids, TorrentAction action) throws RpcException {
        TorrentActionCommand torrentActionCommand = new TorrentActionCommand(nextTag(), action);
        torrentActionCommand.setRequestArguments(ids);
        rpcClient.executeWithHeaders(torrentActionCommand);
    }

    public Long nextTag() {
        return tagProvider.nextTag();
    }

    public <T, V> void executeCommand(RpcCommand<T, V> command) throws RpcException {
        rpcClient.executeWithHeaders(command);
    }
}
