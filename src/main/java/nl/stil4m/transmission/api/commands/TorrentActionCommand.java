package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.TorrentAction;
import nl.stil4m.transmission.api.domain.ids.Ids;
import nl.stil4m.transmission.rpc.RpcCommand;

import java.util.HashMap;
import java.util.Map;

public class TorrentActionCommand extends RpcCommand<Ids, Object> {

    private final Map<TorrentAction, String> torrentActionMap = new HashMap<>();

    {
        torrentActionMap.put(TorrentAction.START, "torrent-start");
        torrentActionMap.put(TorrentAction.START_NOW, "torrent-start-now");
        torrentActionMap.put(TorrentAction.STOP, "torrent-stop");
        torrentActionMap.put(TorrentAction.VERIFY, "torrent-verify");
        torrentActionMap.put(TorrentAction.REANNOUNCE, "torrent-reannounce");
    }

    private final String method;

    public TorrentActionCommand(Long tag, TorrentAction action) {
        super(tag);
        method = torrentActionMap.get(action);
    }

    @Override
    public String getMethod() {
        return method;
    }
}
