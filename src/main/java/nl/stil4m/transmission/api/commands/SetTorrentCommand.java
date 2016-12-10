package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.SetTorrentInfo;
import nl.stil4m.transmission.rpc.RpcCommand;

public class SetTorrentCommand extends RpcCommand<SetTorrentInfo, Void> {

    public SetTorrentCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "torrent-set";
    }
}