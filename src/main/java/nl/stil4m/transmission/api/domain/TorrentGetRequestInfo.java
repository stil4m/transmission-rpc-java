package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TorrentGetRequestInfo {

    private List<Long> ids;

    private List<String> fields;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

}
