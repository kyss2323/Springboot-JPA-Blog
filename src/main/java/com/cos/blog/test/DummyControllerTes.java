package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

// html 파일이 아니라 data를 리턴해주는 controller
@RestController
public class DummyControllerTes {

    // 의존성 주입 (DI)
    @Autowired // DummyControllerTes가 메모리에 뜰때 userRepository도 같이 메모리가 뜬다
    private UserRepository userRepository;

    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    // 한 페이지당 2건의 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> pagingUser =  userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();
        return users;
    }

    // {id} 주소로 파라미터를 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("dummy/user/{id}")
    public User detail(@PathVariable int id){
        // user/4을 찾을때 데이터베이스에서 못찾아오면 user가 null이 될 수 있음.
        // return시 null이 return될 수 있음
        // Optional로 User객체를 감싸서 가져옴 --> null 판단 후 return 해라.
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
            }
        });
        // 람다식
     /*   User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
        })*/

        // 요청 : 웹 브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹 브라우저가 이해할 수 있느 데이터 ) -> json (Gson 라이브러리)
        // 스프링부트 - MessageConverter라는 애가 응답 시에 자동 작동 함.
        // 만약에 자바 오브젝트를 리턴하게 되면, MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 Json으로 변환해서 브라우저에 던짐.
        return user;
    }

    // http://localhost:8000/blog//dummy/join(요청)
    //http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("username : "  + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}
