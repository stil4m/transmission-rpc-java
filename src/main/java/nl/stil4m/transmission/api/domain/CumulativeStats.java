package nl.stil4m.transmission.api.domain;

public class CumulativeStats {

    private Long uploadedBytes;
    private Long downloadedBytes;
    private Long filesAdded;
    private Long sessionCount;
    private Long secondsActive;

    public Long getUploadedBytes() {
        return uploadedBytes;
    }

    public void setUploadedBytes(Long uploadedBytes) {
        this.uploadedBytes = uploadedBytes;
    }

    public Long getDownloadedBytes() {
        return downloadedBytes;
    }

    public void setDownloadedBytes(Long downloadedBytes) {
        this.downloadedBytes = downloadedBytes;
    }

    public Long getFilesAdded() {
        return filesAdded;
    }

    public void setFilesAdded(Long filesAdded) {
        this.filesAdded = filesAdded;
    }

    public Long getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(Long sessionCount) {
        this.sessionCount = sessionCount;
    }

    public Long getSecondsActive() {
        return secondsActive;
    }

    public void setSecondsActive(Long secondsActive) {
        this.secondsActive = secondsActive;
    }
}
