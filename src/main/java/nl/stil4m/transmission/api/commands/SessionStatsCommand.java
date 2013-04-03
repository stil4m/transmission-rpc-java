package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.SessionStats;
import nl.stil4m.transmission.rpc.RpcCommand;

public class SessionStatsCommand extends RpcCommand<Void, SessionStats> {

    public SessionStatsCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "session-stats";
    }
}
