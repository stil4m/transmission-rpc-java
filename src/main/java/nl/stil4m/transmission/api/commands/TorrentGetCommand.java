package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.TorrentGetRequestInfo;
import nl.stil4m.transmission.api.domain.TorrentInfoCollection;
import nl.stil4m.transmission.rpc.RpcCommand;

public class TorrentGetCommand extends RpcCommand<TorrentGetRequestInfo, TorrentInfoCollection> {

    public TorrentGetCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "torrent-get";
    }
}
