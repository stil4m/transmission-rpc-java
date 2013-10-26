package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.api.domain.PortCheckResult;
import nl.stil4m.transmission.rpc.RpcCommand;

public class TestPortCommand extends RpcCommand<Void, PortCheckResult> {

    public TestPortCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "port-test";
    }
}
