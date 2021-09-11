package com.lin.missyou.exception.Http;

public class ParemeterExcepiton extends HttpException{
    public ParemeterExcepiton(int code) {
        this.httpStatusCode = 400;
        this.code = code;

    }
}
