package com.cos.blog.handler;

import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice   // 어떤 곳에서 Exception이 발생해도 이쪽으로 올 수 있도록
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value=IllegalAccessException.class)
    public String handleAccessException(IllegalAccessException e){
        return e.getMessage();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleArgumentException(IllegalArgumentException e){
        return "<h1>" + e.getMessage() + "</h1>";
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseDto<String> handleException(Exception e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR .value(), e.getMessage());
    }

}
