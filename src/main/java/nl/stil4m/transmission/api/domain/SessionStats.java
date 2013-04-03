package nl.stil4m.transmission.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class SessionStats {

    private Long activeTorrentCount;
    private Long downloadSpeed;
    private Long pausedTorrentCount;
    private Long torrentCount;
    private Long uploadSpeed;

    @JsonProperty("cumulative-stats")
    private CumulativeStats cumulativeStats;

    @JsonProperty("current-stats")
    private CurrentStats currentStats;

    public Long getActiveTorrentCount() {
        return activeTorrentCount;
    }

    public void setActiveTorrentCount(Long activeTorrentCount) {
        this.activeTorrentCount = activeTorrentCount;
    }

    public Long getDownloadSpeed() {
        return downloadSpeed;
    }

    public void setDownloadSpeed(Long downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public Long getPausedTorrentCount() {
        return pausedTorrentCount;
    }

    public void setPausedTorrentCount(Long pausedTorrentCount) {
        this.pausedTorrentCount = pausedTorrentCount;
    }

    public Long getTorrentCount() {
        return torrentCount;
    }

    public void setTorrentCount(Long torrentCount) {
        this.torrentCount = torrentCount;
    }

    public Long getUploadSpeed() {
        return uploadSpeed;
    }

    public void setUploadSpeed(Long uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public CumulativeStats getCumulativeStats() {
        return cumulativeStats;
    }

    public void setCumulativeStats(CumulativeStats cumulativeStats) {
        this.cumulativeStats = cumulativeStats;
    }

    public CurrentStats getCurrentStats() {
        return currentStats;
    }

    public void setCurrentStats(CurrentStats currentStats) {
        this.currentStats = currentStats;
    }
}
