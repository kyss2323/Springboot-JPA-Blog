package com.cos.blog.test;

import lombok.*;

//@Getter
//@Setter
@Data // Getter, Setter와 같음
//@AllArgsConstructor // 생성자
@NoArgsConstructor //빈생성자
//@RequiredArgsConstructor
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
