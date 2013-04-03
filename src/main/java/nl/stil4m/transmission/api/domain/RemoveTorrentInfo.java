package nl.stil4m.transmission.api.domain;

import nl.stil4m.transmission.api.domain.ids.Ids;

import org.codehaus.jackson.annotate.JsonProperty;

public class RemoveTorrentInfo {

    private Ids ids;

    @JsonProperty
    private Boolean deleteLocalData;

    public RemoveTorrentInfo(Ids ids, Boolean deleteLocalData) {
        this.ids = ids;
        this.deleteLocalData = deleteLocalData;
    }

    public Object getIds() {
        return ids.theObject();
    }

    public Boolean getDeleteLocalData() {
        return deleteLocalData;
    }
}
