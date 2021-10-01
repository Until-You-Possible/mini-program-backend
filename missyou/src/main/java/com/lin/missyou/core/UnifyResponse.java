package com.lin.missyou.core;

import com.lin.missyou.exception.CreateSuccess;

public class UnifyResponse {

    private int code;
    private String message;
    private String request;

    public static void createSuccess(int code) {
        throw new CreateSuccess(code);
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }

}
