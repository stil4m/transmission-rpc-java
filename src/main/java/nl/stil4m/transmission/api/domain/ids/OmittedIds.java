package nl.stil4m.transmission.api.domain.ids;

public class OmittedIds extends Ids {

    private Object nullObject;

    //NEEDED FOR JACKSON
    public Object getNullObject() {
        return nullObject;
    }

    @Override
    public Object theObject() {
        return nullObject;
    }
}
