package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.RemoveTorrentInfo;
import nl.stil4m.transmission.rpc.RpcCommand;

public class RemoveTorentCommand extends RpcCommand<RemoveTorrentInfo, Object>{

    public RemoveTorentCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "torrent-remove";
    }
}
