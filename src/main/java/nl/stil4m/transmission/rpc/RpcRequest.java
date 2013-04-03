package nl.stil4m.transmission.rpc;

public class RpcRequest<T extends Object> {

    private String method;

    private T arguments;

    private Long tag;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setArguments(T arguments) {
        this.arguments = arguments;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }

    public String getMethod() {
        return method;
    }

    public T getArguments() {
        return arguments;
    }

    public Long getTag() {
        return tag;
    }
}
