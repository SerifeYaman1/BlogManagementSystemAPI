package com.example.demo.core.utils.result;

public class DataResult<T> extends Result{
    public DataResult(T data,boolean success, String message) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data,boolean success) {
        super(success);
        this.data = data;
    }
    public T getData() { //getter
        return data;
    }
    private T data;
}
