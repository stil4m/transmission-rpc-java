package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import nl.stil4m.transmission.api.domain.ids.Ids;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TorrentGetRequestInfo {

    private Ids ids;

    private List<String> fields;

    TorrentGetRequestInfo() {}

    public TorrentGetRequestInfo(Ids ids, List<String> fields) {
        this.ids = ids;
        this.fields = fields;
    }

    public Object getIds() {
        return ids.theObject();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

}
