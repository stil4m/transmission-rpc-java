package nl.stil4m.transmission.api.domain;

public class FileStat {

    private Long bytesCompleted;
    private Boolean wanted;
    private Long priority;

    public Long getBytesCompleted() {
        return bytesCompleted;
    }

    public void setBytesCompleted(Long bytesCompleted) {
        this.bytesCompleted = bytesCompleted;
    }

    public Boolean getWanted() {
        return wanted;
    }

    public void setWanted(Boolean wanted) {
        this.wanted = wanted;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
