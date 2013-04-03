package nl.stil4m.transmission.api.domain;

import java.util.List;

public class ListIds extends Ids {

    private final List<Long> ids;

    public ListIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }
}
