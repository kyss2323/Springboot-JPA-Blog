package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice   // 어떤 곳에서 Exception이 발생해도 이쪽으로 올 수 있도록
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleArgumentException(IllegalArgumentException e){
        return "<h1>" + e.getMessage() + "</h1>";
    }
}
