package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.QueueAction;
import nl.stil4m.transmission.api.domain.ids.Ids;
import nl.stil4m.transmission.rpc.RpcCommand;

import java.util.HashMap;
import java.util.Map;

public class QueueActionCommand extends RpcCommand<Ids, Object> {

    private static final Map<QueueAction, String> TORRENT_ACTION_MAP = new HashMap<QueueAction, String>() {
        {
            put(QueueAction.MOVE_TOP, "queue-move-top");
            put(QueueAction.MOVE_UP, "queue-move-up");
            put(QueueAction.MOVE_DOWN, "queue-move-down");
            put(QueueAction.MOVE_BOTTOM, "queue-move-bottom");
        }
    };

    private final String method;

    public QueueActionCommand(Long tag, QueueAction action) {
        super(tag);
        method = TORRENT_ACTION_MAP.get(action);
    }

    @Override
    public String getMethod() {
        return method;
    }
}
