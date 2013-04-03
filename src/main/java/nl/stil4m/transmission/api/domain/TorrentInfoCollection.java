package nl.stil4m.transmission.api.domain;

import java.util.List;

public class TorrentInfoCollection {

    private List<TorrentInfo> torrents;

    public List<TorrentInfo> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<TorrentInfo> torrents) {
        this.torrents = torrents;
    }
}
