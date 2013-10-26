package nl.stil4m.transmission.rpc;

import java.lang.reflect.ParameterizedType;

public abstract class RpcCommand<T, V> {

    private final Class targetArgclass;
    private T requestArguments;

    public abstract String getMethod();

    private final Long tag;

    private RpcRequest<T> request;
    private RpcResponse<V> response;

    public RpcCommand(Long tag) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        if (genericSuperclass.getActualTypeArguments()[1] instanceof ParameterizedType) {
            ParameterizedType parameterizedType = ((ParameterizedType) genericSuperclass.getActualTypeArguments()[1]);
            targetArgclass = (Class) parameterizedType.getRawType();
        } else {
            this.targetArgclass = ((Class) genericSuperclass.getActualTypeArguments()[1]);
        }

        this.tag = tag;
        request = new RpcRequest<T>();
    }

    public RpcRequest<T> buildRequestPayload() {
        request.setTag(tag);
        request.setMethod(getMethod());
        request.setArguments(requestArguments);
        return request;
    }

    public void setRequestArguments(T requestArguments) {
        this.requestArguments = requestArguments;
    }

    public Long getTag() {
        return tag;
    }

    public void setResponse(RpcResponse<V> response) {
        this.response = response;
    }

    public RpcResponse<V> getResponse() {
        return response;
    }

    public Class getArgumentsObject() {
        return targetArgclass;
    }
}
