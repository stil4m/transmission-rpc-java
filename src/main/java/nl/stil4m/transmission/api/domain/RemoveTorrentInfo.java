package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import nl.stil4m.transmission.api.domain.ids.Ids;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
