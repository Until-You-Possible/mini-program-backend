package com.lin.missyou.exception.Http;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException{
    public NotFoundException(int code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
