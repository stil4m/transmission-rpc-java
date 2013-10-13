package nl.stil4m.transmission.api.domain;

import java.util.List;

public class TorrentInfoCollection {

    private List<TorrentInfo> torrents;

    private List<TorrentInfo> removed;

    public List<TorrentInfo> getRemoved() {
        return removed;
    }

    public void setRemoved(List<TorrentInfo> removed) {
        this.removed = removed;
    }

    public List<TorrentInfo> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<TorrentInfo> torrents) {
        this.torrents = torrents;
    }
}
