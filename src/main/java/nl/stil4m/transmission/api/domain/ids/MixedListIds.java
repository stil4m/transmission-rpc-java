package nl.stil4m.transmission.api.domain.ids;

import java.util.List;

public class MixedListIds extends Ids {

    private final List<Object> ids;

    public MixedListIds(List<Object> ids) {
        for (Object id : ids) {
            if (!(id instanceof Long || id instanceof String)) {
                throw new IllegalArgumentException();
            }
        }
        this.ids = ids;
    }

    public List<Object> getIds() {
        return ids;
    }

    @Override
    public Object theObject() {
        return ids;
    }
}
