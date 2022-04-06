package com.cos.blog.configuration.auth;

import com.cos.blog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
@Getter
public class PrincipalDetail implements UserDetails {
    User user;  // 컴포지션이라 한다.

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴한다. (true: 만료안됨) false시, 로그인 안됨?!
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않았는지 리턴한다. (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호가 만료되지 않았는지 리턴한다. (true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 계정이 활성화(사용가능)인지 리턴한다. (true: 활설화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정의 권한목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야 하는데 우리는 하나만)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        // ROLE_ <-- 스프링 규칙 권한을 나타낼때는 이 prefix를 꼭 붙여야함
        collectors.add(()->{return "ROLE_" + user.getRole();});

        return null;
    }
}
