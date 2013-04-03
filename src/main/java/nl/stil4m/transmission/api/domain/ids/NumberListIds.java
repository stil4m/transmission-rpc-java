package nl.stil4m.transmission.api.domain.ids;

import java.util.List;

public class NumberListIds extends Ids {

    private final List<Long> ids;

    public NumberListIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    @Override
    public Object theObject() {
        return ids;
    }
}
