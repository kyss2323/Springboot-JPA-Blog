package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
    //http://localhost:8080/test/hello
    @GetMapping("/test/hello")
    public String hello(){
        return "<H1>Hello spring boot</H1>";
    }
}
