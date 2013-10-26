package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import nl.stil4m.transmission.api.domain.ids.Ids;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RemoveTorrentInfo {

    private Ids ids;

    @JsonProperty
    private Boolean deleteLocalData;

    public RemoveTorrentInfo(Ids ids, Boolean deleteLocalData) {
        this.ids = ids;
        this.deleteLocalData = deleteLocalData;
    }

    public Object getIds() {
        if (ids == null) {
            return null;
        }
        return ids.theObject();
    }

    public Boolean getDeleteLocalData() {
        return deleteLocalData;
    }
}
