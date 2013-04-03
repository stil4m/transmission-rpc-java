package nl.stil4m.transmission.api.domain;

public class PeerFrom {

    private Long fromCache;
    private Long fromDht;
    private Long fromIncoming;
    private Long fromLpd;
    private Long fromLtep;
    private Long fromPex;
    private Long fromTracker;

    public Long getFromCache() {
        return fromCache;
    }

    public void setFromCache(Long fromCache) {
        this.fromCache = fromCache;
    }

    public Long getFromDht() {
        return fromDht;
    }

    public void setFromDht(Long fromDht) {
        this.fromDht = fromDht;
    }

    public Long getFromIncoming() {
        return fromIncoming;
    }

    public void setFromIncoming(Long fromIncoming) {
        this.fromIncoming = fromIncoming;
    }

    public Long getFromLpd() {
        return fromLpd;
    }

    public void setFromLpd(Long fromLpd) {
        this.fromLpd = fromLpd;
    }

    public Long getFromLtep() {
        return fromLtep;
    }

    public void setFromLtep(Long fromLtep) {
        this.fromLtep = fromLtep;
    }

    public Long getFromPex() {
        return fromPex;
    }

    public void setFromPex(Long fromPex) {
        this.fromPex = fromPex;
    }

    public Long getFromTracker() {
        return fromTracker;
    }

    public void setFromTracker(Long fromTracker) {
        this.fromTracker = fromTracker;
    }
}
