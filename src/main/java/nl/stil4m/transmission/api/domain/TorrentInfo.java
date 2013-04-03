package nl.stil4m.transmission.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class TorrentInfo {

    private Long activityDate;
    private Long addedDate;
    private Long bandwidthPriority;

    private String comment;

    private Long corruptEver;

    private String creator;

    private Long dateAdded;

    private Long dateCreated;
    private Long desiredAvailable;
    private Long doneDate;
    private String downloadDir;
    private Long downloadedEver;
    private Long downloadLimit;
    private Boolean downloadLimited;
    private Long error;
    private String errorString;
    private Long eta;
    private Long etaIdle;
    private List<File> files;
    private List<FileStat> fileStats;
    private String hashString;
    private Long haveUnchecked;
    private Long haveValid;
    private Boolean honorsSessionLimits;
    private Long id;

    @JsonProperty("isFinished")
    private Boolean isFinished;

    @JsonProperty("isPrivate")
    private Boolean isPrivate;

    @JsonProperty("isStalled")
    private Boolean isStalled;

    private Long leftUntilDone;
    private String magnetLink;
    private Long manualAnnounceTime;
    private Long maxConnectedPeers;
    private Double metadataPercentComplete;
    private String name;

    @JsonProperty("peer-limit")
    private Long peerLimit;
    private List<Peer> peers;
    private Long peersConnected;
    private Object peersFrom;
    private Long peersGettingFromUs;
    private Long peersSendingToUs;
    private Double percentDone;
    private String pieces;
    private Long pieceCount;
    private Long pieceSize;
    private List<Integer> priorities;
    private Long queuePosition;
    private Long rateDownload;
    private Long rateUpload;
    private Double recheckProgress;
    private Long secondsDownloading;
    private Long secondsSeeding;
    private Long seedIdleLimit;
    private Long seedIdleMode;
    private Double seedRatioLimit;
    private Long seedRatioMode;
    private Long sizeWhenDone;
    private Long startDate;
    private Long status;
    private List<Tracker> trackers;
    private List<TrackerStat> trackerStats;
    private Long totalSize;
    private String torrentFile;
    private Long uploadedEver;
    private Long uploadLimit;
    private Boolean uploadLimited;
    private Double uploadRatio;
    private List wanted;
    private List webseeds;
    private Long webseedsSendingToUs;

    public Long getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Long activityDate) {
        this.activityDate = activityDate;
    }

    public Long getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Long addedDate) {
        this.addedDate = addedDate;
    }

    public Long getBandwidthPriority() {
        return bandwidthPriority;
    }

    public void setBandwidthPriority(Long bandwidthPriority) {
        this.bandwidthPriority = bandwidthPriority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCorruptEver() {
        return corruptEver;
    }

    public void setCorruptEver(Long corruptEver) {
        this.corruptEver = corruptEver;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDesiredAvailable() {
        return desiredAvailable;
    }

    public void setDesiredAvailable(Long desiredAvailable) {
        this.desiredAvailable = desiredAvailable;
    }

    public Long getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Long doneDate) {
        this.doneDate = doneDate;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    public Long getDownloadedEver() {
        return downloadedEver;
    }

    public void setDownloadedEver(Long downloadedEver) {
        this.downloadedEver = downloadedEver;
    }

    public Long getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(Long downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public Boolean getDownloadLimited() {
        return downloadLimited;
    }

    public void setDownloadLimited(Boolean downloadLimited) {
        this.downloadLimited = downloadLimited;
    }

    public Long getError() {
        return error;
    }

    public void setError(Long error) {
        this.error = error;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public Long getEta() {
        return eta;
    }

    public void setEta(Long eta) {
        this.eta = eta;
    }

    public Long getEtaIdle() {
        return etaIdle;
    }

    public void setEtaIdle(Long etaIdle) {
        this.etaIdle = etaIdle;
    }

    public String getHashString() {
        return hashString;
    }

    public void setHashString(String hashString) {
        this.hashString = hashString;
    }

    public Long getHaveUnchecked() {
        return haveUnchecked;
    }

    public void setHaveUnchecked(Long haveUnchecked) {
        this.haveUnchecked = haveUnchecked;
    }

    public Long getHaveValid() {
        return haveValid;
    }

    public void setHaveValid(Long haveValid) {
        this.haveValid = haveValid;
    }

    public Boolean getHonorsSessionLimits() {
        return honorsSessionLimits;
    }

    public void setHonorsSessionLimits(Boolean honorsSessionLimits) {
        this.honorsSessionLimits = honorsSessionLimits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Boolean getStalled() {
        return isStalled;
    }

    public void setStalled(Boolean stalled) {
        isStalled = stalled;
    }

    public Long getLeftUntilDone() {
        return leftUntilDone;
    }

    public void setLeftUntilDone(Long leftUntilDone) {
        this.leftUntilDone = leftUntilDone;
    }

    public String getMagnetLink() {
        return magnetLink;
    }

    public void setMagnetLink(String magnetLink) {
        this.magnetLink = magnetLink;
    }

    public Long getManualAnnounceTime() {
        return manualAnnounceTime;
    }

    public void setManualAnnounceTime(Long manualAnnounceTime) {
        this.manualAnnounceTime = manualAnnounceTime;
    }

    public Long getMaxConnectedPeers() {
        return maxConnectedPeers;
    }

    public void setMaxConnectedPeers(Long maxConnectedPeers) {
        this.maxConnectedPeers = maxConnectedPeers;
    }

    public Double getMetadataPercentComplete() {
        return metadataPercentComplete;
    }

    public void setMetadataPercentComplete(Double metadataPercentComplete) {
        this.metadataPercentComplete = metadataPercentComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPeerLimit() {
        return peerLimit;
    }

    public void setPeerLimit(Long peerLimit) {
        this.peerLimit = peerLimit;
    }

    public Long getPeersConnected() {
        return peersConnected;
    }

    public void setPeersConnected(Long peersConnected) {
        this.peersConnected = peersConnected;
    }

    public Object getPeersFrom() {
        return peersFrom;
    }

    public void setPeersFrom(Object peersFrom) {
        this.peersFrom = peersFrom;
    }

    public Long getPeersGettingFromUs() {
        return peersGettingFromUs;
    }

    public void setPeersGettingFromUs(Long peersGettingFromUs) {
        this.peersGettingFromUs = peersGettingFromUs;
    }

    public Long getPeersSendingToUs() {
        return peersSendingToUs;
    }

    public void setPeersSendingToUs(Long peersSendingToUs) {
        this.peersSendingToUs = peersSendingToUs;
    }

    public Double getPercentDone() {
        return percentDone;
    }

    public void setPercentDone(Double percentDone) {
        this.percentDone = percentDone;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public Long getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(Long pieceCount) {
        this.pieceCount = pieceCount;
    }

    public Long getPieceSize() {
        return pieceSize;
    }

    public void setPieceSize(Long pieceSize) {
        this.pieceSize = pieceSize;
    }


    public Long getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(Long queuePosition) {
        this.queuePosition = queuePosition;
    }

    public Long getRateDownload() {
        return rateDownload;
    }

    public void setRateDownload(Long rateDownload) {
        this.rateDownload = rateDownload;
    }

    public Long getRateUpload() {
        return rateUpload;
    }

    public void setRateUpload(Long rateUpload) {
        this.rateUpload = rateUpload;
    }

    public Double getRecheckProgress() {
        return recheckProgress;
    }

    public void setRecheckProgress(Double recheckProgress) {
        this.recheckProgress = recheckProgress;
    }

    public Long getSecondsDownloading() {
        return secondsDownloading;
    }

    public void setSecondsDownloading(Long secondsDownloading) {
        this.secondsDownloading = secondsDownloading;
    }

    public Long getSecondsSeeding() {
        return secondsSeeding;
    }

    public void setSecondsSeeding(Long secondsSeeding) {
        this.secondsSeeding = secondsSeeding;
    }

    public Long getSeedIdleLimit() {
        return seedIdleLimit;
    }

    public void setSeedIdleLimit(Long seedIdleLimit) {
        this.seedIdleLimit = seedIdleLimit;
    }

    public Long getSeedIdleMode() {
        return seedIdleMode;
    }

    public void setSeedIdleMode(Long seedIdleMode) {
        this.seedIdleMode = seedIdleMode;
    }

    public Double getSeedRatioLimit() {
        return seedRatioLimit;
    }

    public void setSeedRatioLimit(Double seedRatioLimit) {
        this.seedRatioLimit = seedRatioLimit;
    }

    public Long getSeedRatioMode() {
        return seedRatioMode;
    }

    public void setSeedRatioMode(Long seedRatioMode) {
        this.seedRatioMode = seedRatioMode;
    }

    public Long getSizeWhenDone() {
        return sizeWhenDone;
    }

    public void setSizeWhenDone(Long sizeWhenDone) {
        this.sizeWhenDone = sizeWhenDone;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }


    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public String getTorrentFile() {
        return torrentFile;
    }

    public void setTorrentFile(String torrentFile) {
        this.torrentFile = torrentFile;
    }

    public Long getUploadedEver() {
        return uploadedEver;
    }

    public void setUploadedEver(Long uploadedEver) {
        this.uploadedEver = uploadedEver;
    }

    public Long getUploadLimit() {
        return uploadLimit;
    }

    public void setUploadLimit(Long uploadLimit) {
        this.uploadLimit = uploadLimit;
    }

    public Boolean getUploadLimited() {
        return uploadLimited;
    }

    public void setUploadLimited(Boolean uploadLimited) {
        this.uploadLimited = uploadLimited;
    }

    public Double getUploadRatio() {
        return uploadRatio;
    }

    public void setUploadRatio(Double uploadRatio) {
        this.uploadRatio = uploadRatio;
    }


    public Long getWebseedsSendingToUs() {
        return webseedsSendingToUs;
    }

    public void setWebseedsSendingToUs(Long webseedsSendingToUs) {
        this.webseedsSendingToUs = webseedsSendingToUs;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<FileStat> getFileStats() {
        return fileStats;
    }

    public void setFileStats(List<FileStat> fileStats) {
        this.fileStats = fileStats;
    }

    public List<Peer> getPeers() {
        return peers;
    }

    public void setPeers(List<Peer> peers) {
        this.peers = peers;
    }

    public List<Integer> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<Integer> priorities) {
        this.priorities = priorities;
    }

    public List<Tracker> getTrackers() {
        return trackers;
    }

    public void setTrackers(List<Tracker> trackers) {
        this.trackers = trackers;
    }

    public List<TrackerStat> getTrackerStats() {
        return trackerStats;
    }

    public void setTrackerStats(List<TrackerStat> trackerStats) {
        this.trackerStats = trackerStats;
    }

    public List getWanted() {
        return wanted;
    }

    public void setWanted(List wanted) {
        this.wanted = wanted;
    }

    public List getWebseeds() {
        return webseeds;
    }

    public void setWebseeds(List webseeds) {
        this.webseeds = webseeds;
    }
}
