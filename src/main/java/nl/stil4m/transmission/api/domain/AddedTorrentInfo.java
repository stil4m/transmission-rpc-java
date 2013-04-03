package nl.stil4m.transmission.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddedTorrentInfo {

    @JsonProperty("torrent-added")
    private TorrentInfo torrentAdded;
}
