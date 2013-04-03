package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.AddTorrentInfo;
import nl.stil4m.transmission.api.domain.AddedTorrentInfo;
import nl.stil4m.transmission.rpc.RpcCommand;

public class AddTorrentCommand extends RpcCommand<AddTorrentInfo, AddedTorrentInfo> {

    public AddTorrentCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "torrent-add";
    }
}
