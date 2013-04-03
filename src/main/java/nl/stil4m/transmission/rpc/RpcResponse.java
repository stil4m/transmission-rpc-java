package nl.stil4m.transmission.rpc;

public class RpcResponse<T extends Object> {

    private T arguments;

    private String result;

    private Integer tag;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getArguments() {
        return arguments;
    }

    public void setArguments(T arguments) {
        this.arguments = arguments;
    }
}
