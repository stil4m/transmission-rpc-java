package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedTorrentInfo {


    private final TorrentInfo torrentInfo;

    private final boolean isDuplicate;

    @JsonCreator
    public AddedTorrentInfo(@JsonProperty("torrent-added") TorrentInfo torrentAdded,
                            @JsonProperty("torrent-duplicate") TorrentInfo torrentDuplicate) {
        TorrentInfo newTorrentInfo = null;
        if (torrentAdded != null) {
            newTorrentInfo = torrentAdded;
        }
        if (torrentDuplicate != null) {
            isDuplicate = true;
            newTorrentInfo = torrentDuplicate;
        } else {
            isDuplicate = false;
        }
        this.torrentInfo = newTorrentInfo;
    }

    public TorrentInfo getTorrentInfo() {
        return torrentInfo;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }
}
