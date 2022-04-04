package com.cos.blog.configuration;

import com.cos.blog.configuration.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // 빈등록
@EnableWebSecurity  // 시큐리티 필터가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PrincipalDetailService principalDetailService;

    @Bean   // IoC 등록
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인할 때, password를 가로채기를 하는데
    // 해당 password가 뭘로 해쉬가 되어 회원가입이 되었느지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .csrf().disable()   // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
                .authorizeRequests()
                    .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/auth/loginForm")
                    .loginProcessingUrl("/auth/loginProc")
                    .defaultSuccessUrl("/");
    }
}
