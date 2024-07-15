package com.example.demo.core.utils.result;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success); //kod tekrarı olmaması için
        this.message = message;
    }

    public boolean isSuccess() { //getter
        return success;
    }

    public String getMessage() { //getter
        return message;
    }
}
