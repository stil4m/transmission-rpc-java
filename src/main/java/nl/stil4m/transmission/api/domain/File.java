package nl.stil4m.transmission.api.domain;

public class File {

    private Long bytesCompleted;
    private Long length;
    private String name;

    public Long getBytesCompleted() {
        return bytesCompleted;
    }

    public void setBytesCompleted(Long bytesCompleted) {
        this.bytesCompleted = bytesCompleted;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
