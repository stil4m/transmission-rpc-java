package nl.stil4m.transmission.rpc;

public class RpcException extends Throwable {
    private String explanation;
    private RpcCommand command;

    public RpcException(Throwable t) {
        super(t);
    }

    public RpcException(String reason, String explanation, RpcCommand command) {
        super(reason+ ": " + explanation);
        this.explanation = explanation;
        this.command = command;
    }

    public String getExplanation() {
        return explanation;
    }

    public RpcCommand getCommand() {
        return command;
    }
}
