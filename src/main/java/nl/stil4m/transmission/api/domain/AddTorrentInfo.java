package nl.stil4m.transmission.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class AddTorrentInfo {
    private String cookies;

    @JsonProperty("download-dir")
    private String downloadDir;
    private String filename;
    private String metainfo;

    private Boolean paused;

    @JsonProperty("peer-limit")
    private Long peerLimit;

    private Long bandwidthPriority;

    @JsonProperty("files-wanted")
    private List<String> filesWanted;

    @JsonProperty("files-unwanted")
    private List<String> filesUnwanted;


    @JsonProperty("priority-high")
    private List<String> priorityHigh;

    @JsonProperty("priority-low")
    private List<String> priorityLow;

    @JsonProperty("priority-normal")
    private List<String> priorityNormal;

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMetainfo() {
        return metainfo;
    }

    public void setMetainfo(String metainfo) {
        this.metainfo = metainfo;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public Long getPeerLimit() {
        return peerLimit;
    }

    public void setPeerLimit(Long peerLimit) {
        this.peerLimit = peerLimit;
    }

    public Long getBandwidthPriority() {
        return bandwidthPriority;
    }

    public void setBandwidthPriority(Long bandwidthPriority) {
        this.bandwidthPriority = bandwidthPriority;
    }

    public List<String> getFilesWanted() {
        return filesWanted;
    }

    public void setFilesWanted(List<String> filesWanted) {
        this.filesWanted = filesWanted;
    }

    public List<String> getFilesUnwanted() {
        return filesUnwanted;
    }

    public void setFilesUnwanted(List<String> filesUnwanted) {
        this.filesUnwanted = filesUnwanted;
    }

    public List<String> getPriorityHigh() {
        return priorityHigh;
    }

    public void setPriorityHigh(List<String> priorityHigh) {
        this.priorityHigh = priorityHigh;
    }

    public List<String> getPriorityLow() {
        return priorityLow;
    }

    public void setPriorityLow(List<String> priorityLow) {
        this.priorityLow = priorityLow;
    }

    public List<String> getPriorityNormal() {
        return priorityNormal;
    }

    public void setPriorityNormal(List<String> priorityNormal) {
        this.priorityNormal = priorityNormal;
    }
}

