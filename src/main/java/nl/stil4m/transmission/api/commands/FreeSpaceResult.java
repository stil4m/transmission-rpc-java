package nl.stil4m.transmission.api.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FreeSpaceResult {

    private String path;

    private Long sizeBytes;

    @JsonCreator
    public FreeSpaceResult(@JsonProperty("path") String path, @JsonProperty("size-bytes") Long sizeBytes) {
        this.path = path;
        this.sizeBytes = sizeBytes;
    }

    public String getPath() {
        return path;
    }

    public Long getSizeBytes() {
        return sizeBytes;
    }
}
