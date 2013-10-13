package nl.stil4m.transmission.rpc;

public class RpcException extends Throwable {
    private RpcCommand command;

    public RpcException(Throwable t) {
        super(t);
    }

    public RpcException(String reason, RpcCommand command) {
        super(reason);
        this.command = command;
    }

    public RpcException(String reason) {
        super(reason);
    }

    public RpcCommand getCommand() {
        return command;
    }
}
