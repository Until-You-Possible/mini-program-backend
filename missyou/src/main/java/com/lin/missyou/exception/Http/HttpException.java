package com.lin.missyou.exception.Http;

public class HttpException extends RuntimeException{
    protected Integer code;

    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
