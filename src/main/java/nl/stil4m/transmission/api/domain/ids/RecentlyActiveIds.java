package nl.stil4m.transmission.api.domain.ids;

public class RecentlyActiveIds extends Ids {

    private static final String IDS = "recently-active";

    public String getIds() {
        return IDS;
    }

    @Override
    public Object theObject() {
        return IDS;
    }
}
