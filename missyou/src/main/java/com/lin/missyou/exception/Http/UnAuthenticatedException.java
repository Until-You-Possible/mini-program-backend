package com.lin.missyou.exception.Http;

public class UnAuthenticatedException extends HttpException{
    public UnAuthenticatedException(int code){
        this.code = code;
        this.httpStatusCode = 401;
    }
}
