package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController {
        //http://localhost:8000/blog/temp/home
        @GetMapping("/temp/home")
        public String tempHome(){
                System.out.println("temphome()");
                //파일리턴 기본경로: src/main/resources/static
                //리턴명: /home.html
                //풀경로: src/main/resources/static/home.html
                return "/home.html";
        }

        //http://localhost:8000/blog/temp/img
        @GetMapping("/temp/img")
        public String tempImg(){
                return "/a.png";
        }

        //http://localhost:8000/blog/temp/img
        @RequestMapping("/temp/jsp")
        public String tempJsp(){
                //prefix: /WEB-INF/views/
                //suffix: .jsp
                //full name:
                return "/test";
        }
}
