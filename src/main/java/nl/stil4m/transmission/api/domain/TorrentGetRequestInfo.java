package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import nl.stil4m.transmission.api.domain.ids.Ids;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TorrentGetRequestInfo {

    private Ids ids;

    private List<String> fields;

    public TorrentGetRequestInfo(Ids ids, List<String> fields) {
        this.ids = ids;
        this.fields = fields;
    }

    public Object getIds() {
        if (ids == null) {
            return ids;
        }
        return ids.theObject();
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

}
