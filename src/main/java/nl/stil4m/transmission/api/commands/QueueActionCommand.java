package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.QueueAction;
import nl.stil4m.transmission.api.domain.ids.Ids;
import nl.stil4m.transmission.rpc.RpcCommand;

import java.util.HashMap;
import java.util.Map;

public class QueueActionCommand extends RpcCommand<Ids, Object> {

    private final Map<QueueAction, String> torrentActionMap = new HashMap<>();

    {
        torrentActionMap.put(QueueAction.MOVE_TOP, "queue-move-top");
        torrentActionMap.put(QueueAction.MOVE_UP, "queue-move-up");
        torrentActionMap.put(QueueAction.MOVE_DOWN, "queue-move-down");
        torrentActionMap.put(QueueAction.MOVE_BOTTOM, "queue-move-bottom");
    }

    private final String method;

    public QueueActionCommand(Long tag, QueueAction action) {
        super(tag);
        method = torrentActionMap.get(action);
    }

    @Override
    public String getMethod() {
        return method;
    }
}
