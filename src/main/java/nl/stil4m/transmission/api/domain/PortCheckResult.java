package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PortCheckResult {

    private final Boolean open;

    @JsonCreator
    public PortCheckResult(@JsonProperty("port-is-open") Boolean open) {
        this.open = open;
    }

    public Boolean getOpen() {
        return open;
    }
}
