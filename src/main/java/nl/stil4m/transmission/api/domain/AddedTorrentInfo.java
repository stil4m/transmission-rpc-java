package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedTorrentInfo {


    private final TorrentInfo torrentInfo;

    @JsonCreator
    public AddedTorrentInfo(@JsonProperty("torrent-added") TorrentInfo torrentAdded,
                            @JsonProperty("torrent-duplicate") TorrentInfo torrentDuplicate) {
        TorrentInfo newTorrentInfo = null;
        if (torrentAdded != null) {
            newTorrentInfo = torrentAdded;
        }
        if (torrentDuplicate != null) {
            newTorrentInfo = torrentDuplicate;
        }
        this.torrentInfo = newTorrentInfo;
    }

    public TorrentInfo getTorrentInfo() {
        return torrentInfo;
    }
}
