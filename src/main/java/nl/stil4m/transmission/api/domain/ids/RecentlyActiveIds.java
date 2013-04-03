package nl.stil4m.transmission.api.domain.ids;

public class RecentlyActiveIds extends Ids {

    private final String ids = "recently-active";

    public String getIds() {
        return ids;
    }

    @Override
    public Object theObject() {
        return ids;
    }
}
