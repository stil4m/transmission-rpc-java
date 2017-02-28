package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedTorrentInfo {


    private final TorrentInfo torrentAdded;
    private final TorrentInfo torrentDuplicate;

    @JsonCreator
    public AddedTorrentInfo(@JsonProperty("torrent-added") TorrentInfo torrentAdded,
                            @JsonProperty("torrent-duplicate") TorrentInfo torrentDuplicate) {
        this.torrentAdded = torrentAdded;
        this.torrentDuplicate = torrentDuplicate;
    }

    public TorrentInfo getTorrentInfo() {
        return torrentAdded == null ? torrentDuplicate : torrentAdded;
    }

    public boolean isDuplicate() {
        return torrentDuplicate != null;
    }

    public TorrentInfo getTorrentAdded() {
        return torrentAdded;
    }

    public TorrentInfo getTorrentDuplicate() {
        return torrentDuplicate;
    }
}
