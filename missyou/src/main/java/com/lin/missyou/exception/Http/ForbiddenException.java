package com.lin.missyou.exception.Http;

public class ForbiddenException extends HttpException{
    public ForbiddenException(int code) {
        this.httpStatusCode = 403;
        this.code = code;

    }
}
