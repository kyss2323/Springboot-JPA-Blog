//package com.cos.blog.test;
//
//import org.springframework.web.bind.annotation.*;
//
////사용자가 요청 0> 응답(HTML 파일)
////@Controller
//
//// 사용자가 요청 -> 응답(Data)
//@RestController
//public class HttpController {
//    private static final String TAG = "HttpController";
//
//    @GetMapping("/http/lombok")
//    public String lombokTest(){
//        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
//        System.out.println(TAG + "getter : " + m.getUsername());
//        m.setUsername("test");
//        System.out.println(TAG + "setter : " + m.getUsername());
//        return "lombok test완료";
//    }
//    //http://localhost:8080/http/get (select)
//    @GetMapping("/http/get")
//    public String getTest(Member m){
//        return "Get 요청 : " + m.getId() + ", " + m.getUsername()+", " + m.getPassword() + ", " + m.getEmail();
//    }
//    //http://localhost:8080/http/post  (insert)
//    @PostMapping("/http/post")
//    public String postTest(@RequestBody Member m){  //MessageConverter(스프링부트) 자동으로 매핑
//        return "Post 요청 :  " + m.getId() + ", " + m.getUsername()+", " + m.getPassword() + ", " + m.getEmail();
//    }
//    //http://localhost:8080/http/put (put)
//    @PutMapping("/http/put")
//    public String putTest(){
//        return "Put 요청";
//    }
//    //http://localhost:8080/http/delete (delete)
//    @DeleteMapping("/http/delete")
//    public String DeleteTest(){
//        return "Delete 요청";
//    }
//
//}
