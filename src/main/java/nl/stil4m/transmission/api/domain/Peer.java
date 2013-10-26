package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Peer {

    private String address;
    private String clientName;
    private Boolean clientIsChoked;
    private Boolean clientIsInterested;
    private String flagStr;

    @JsonProperty("isDownloadingFrom")
    private Boolean isDownloadingFrom;

    @JsonProperty("isEncrypted")
    private Boolean isEncrypted;

    @JsonProperty("isIncoming")
    private Boolean isIncoming;
    @JsonProperty("isUploadingTo")
    private Boolean isUploadingTo;
    @JsonProperty("isUTP")
    private Boolean utp;
    private Boolean peerIsChoked;
    private Boolean peerIsInterested;
    private Long port;
    private Double progress;
    private Long rateToClient;
    private Long rateToPeer;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Boolean getClientIsChoked() {
        return clientIsChoked;
    }

    public void setClientIsChoked(Boolean clientIsChoked) {
        this.clientIsChoked = clientIsChoked;
    }

    public Boolean getClientIsInterested() {
        return clientIsInterested;
    }

    public void setClientIsInterested(Boolean clientIsInterested) {
        this.clientIsInterested = clientIsInterested;
    }

    public String getFlagStr() {
        return flagStr;
    }

    public void setFlagStr(String flagStr) {
        this.flagStr = flagStr;
    }

    public Boolean getDownloadingFrom() {
        return isDownloadingFrom;
    }

    public void setDownloadingFrom(Boolean downloadingFrom) {
        isDownloadingFrom = downloadingFrom;
    }

    public Boolean getEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        isEncrypted = encrypted;
    }

    public Boolean getIncoming() {
        return isIncoming;
    }

    public void setIncoming(Boolean incoming) {
        isIncoming = incoming;
    }

    public Boolean getUploadingTo() {
        return isUploadingTo;
    }

    public void setUploadingTo(Boolean uploadingTo) {
        isUploadingTo = uploadingTo;
    }

    public Boolean getUTP() {
        return utp;
    }

    public void setUTP(Boolean utp) {
        this.utp = utp;
    }

    public Boolean getPeerIsChoked() {
        return peerIsChoked;
    }

    public void setPeerIsChoked(Boolean peerIsChoked) {
        this.peerIsChoked = peerIsChoked;
    }

    public Boolean getPeerIsInterested() {
        return peerIsInterested;
    }

    public void setPeerIsInterested(Boolean peerIsInterested) {
        this.peerIsInterested = peerIsInterested;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Long getRateToClient() {
        return rateToClient;
    }

    public void setRateToClient(Long rateToClient) {
        this.rateToClient = rateToClient;
    }

    public Long getRateToPeer() {
        return rateToPeer;
    }

    public void setRateToPeer(Long rateToPeer) {
        this.rateToPeer = rateToPeer;
    }
}
