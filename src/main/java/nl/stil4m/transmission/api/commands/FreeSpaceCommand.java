package nl.stil4m.transmission.api.commands;

import nl.stil4m.transmission.rpc.RpcCommand;

public class FreeSpaceCommand extends RpcCommand<FreeSpacePath, FreeSpaceResult>{

    public FreeSpaceCommand(Long tag) {
        super(tag);
    }

    @Override
    public String getMethod() {
        return "free-space";
    }

}
