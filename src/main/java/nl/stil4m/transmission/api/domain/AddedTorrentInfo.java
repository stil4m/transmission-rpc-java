package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddedTorrentInfo {


    private final TorrentInfo torrentAdded;

    @JsonCreator
    public AddedTorrentInfo(@JsonProperty("torrent-added") TorrentInfo torrentAdded) {
        this.torrentAdded = torrentAdded;
    }

    public TorrentInfo getTorrentAdded() {
        return torrentAdded;
    }
}
