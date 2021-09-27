package com.lin.missyou.exception.Http;

public class CreateSuccess extends HttpException {
    public CreateSuccess(int code){
        this.httpStatusCode = 201;
        this.code = code;
    }
}
