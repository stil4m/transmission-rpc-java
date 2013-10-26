package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackerStat {

    private String announce;
    private Long announceState;
    private Long downloadCount;
    private Boolean hasAnnounced;
    private Boolean hasScraped;
    private String host;
    private Long id;
    @JsonProperty("isBackup")
    private Boolean isBackup;
    private Long lastAnnouncePeerCount;
    private String lastAnnounceResult;
    private Long lastAnnounceStartTime;
    private Boolean lastAnnounceSucceeded;
    private Long lastAnnounceTime;
    private Boolean lastAnnounceTimedOut;
    private String lastScrapeResult;
    private Long lastScrapeStartTime;
    private Boolean lastScrapeSucceeded;
    private Long lastScrapeTime;
    private Boolean lastScrapeTimedOut;
    private Long leecherCount;
    private Long nextAnnounceTime;
    private Long nextScrapeTime;
    private String scrape;
    private Long scrapeState;
    private Long seederCount;
    private Long tier;

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public Long getAnnounceState() {
        return announceState;
    }

    public void setAnnounceState(Long announceState) {
        this.announceState = announceState;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Boolean getHasAnnounced() {
        return hasAnnounced;
    }

    public void setHasAnnounced(Boolean hasAnnounced) {
        this.hasAnnounced = hasAnnounced;
    }

    public Boolean getHasScraped() {
        return hasScraped;
    }

    public void setHasScraped(Boolean hasScraped) {
        this.hasScraped = hasScraped;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBackup() {
        return isBackup;
    }

    public void setBackup(Boolean backup) {
        isBackup = backup;
    }

    public Long getLastAnnouncePeerCount() {
        return lastAnnouncePeerCount;
    }

    public void setLastAnnouncePeerCount(Long lastAnnouncePeerCount) {
        this.lastAnnouncePeerCount = lastAnnouncePeerCount;
    }

    public String getLastAnnounceResult() {
        return lastAnnounceResult;
    }

    public void setLastAnnounceResult(String lastAnnounceResult) {
        this.lastAnnounceResult = lastAnnounceResult;
    }

    public Long getLastAnnounceStartTime() {
        return lastAnnounceStartTime;
    }

    public void setLastAnnounceStartTime(Long lastAnnounceStartTime) {
        this.lastAnnounceStartTime = lastAnnounceStartTime;
    }

    public Boolean getLastAnnounceSucceeded() {
        return lastAnnounceSucceeded;
    }

    public void setLastAnnounceSucceeded(Boolean lastAnnounceSucceeded) {
        this.lastAnnounceSucceeded = lastAnnounceSucceeded;
    }

    public Long getLastAnnounceTime() {
        return lastAnnounceTime;
    }

    public void setLastAnnounceTime(Long lastAnnounceTime) {
        this.lastAnnounceTime = lastAnnounceTime;
    }

    public Boolean getLastAnnounceTimedOut() {
        return lastAnnounceTimedOut;
    }

    public void setLastAnnounceTimedOut(Boolean lastAnnounceTimedOut) {
        this.lastAnnounceTimedOut = lastAnnounceTimedOut;
    }

    public String getLastScrapeResult() {
        return lastScrapeResult;
    }

    public void setLastScrapeResult(String lastScrapeResult) {
        this.lastScrapeResult = lastScrapeResult;
    }

    public Long getLastScrapeStartTime() {
        return lastScrapeStartTime;
    }

    public void setLastScrapeStartTime(Long lastScrapeStartTime) {
        this.lastScrapeStartTime = lastScrapeStartTime;
    }

    public Boolean getLastScrapeSucceeded() {
        return lastScrapeSucceeded;
    }

    public void setLastScrapeSucceeded(Boolean lastScrapeSucceeded) {
        this.lastScrapeSucceeded = lastScrapeSucceeded;
    }

    public Long getLastScrapeTime() {
        return lastScrapeTime;
    }

    public void setLastScrapeTime(Long lastScrapeTime) {
        this.lastScrapeTime = lastScrapeTime;
    }

    public Boolean getLastScrapeTimedOut() {
        return lastScrapeTimedOut;
    }

    public void setLastScrapeTimedOut(Boolean lastScrapeTimedOut) {
        this.lastScrapeTimedOut = lastScrapeTimedOut;
    }

    public Long getLeecherCount() {
        return leecherCount;
    }

    public void setLeecherCount(Long leecherCount) {
        this.leecherCount = leecherCount;
    }

    public Long getNextAnnounceTime() {
        return nextAnnounceTime;
    }

    public void setNextAnnounceTime(Long nextAnnounceTime) {
        this.nextAnnounceTime = nextAnnounceTime;
    }

    public Long getNextScrapeTime() {
        return nextScrapeTime;
    }

    public void setNextScrapeTime(Long nextScrapeTime) {
        this.nextScrapeTime = nextScrapeTime;
    }

    public String getScrape() {
        return scrape;
    }

    public void setScrape(String scrape) {
        this.scrape = scrape;
    }

    public Long getScrapeState() {
        return scrapeState;
    }

    public void setScrapeState(Long scrapeState) {
        this.scrapeState = scrapeState;
    }

    public Long getSeederCount() {
        return seederCount;
    }

    public void setSeederCount(Long seederCount) {
        this.seederCount = seederCount;
    }

    public Long getTier() {
        return tier;
    }

    public void setTier(Long tier) {
        this.tier = tier;
    }
}
