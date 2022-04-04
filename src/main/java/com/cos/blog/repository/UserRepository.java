package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// DAO
// 자동으로 bean 등록이 됨
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
    // SELECT * FROM USER WHERE username = ?1;
    Optional<User> findByUsername(String username);
}
//JPA Naming 쿼리
// SELECT * FROM user WHERE username = ?1 AND password = ?2;
// Optional<User> findByUsernameAndPassword(String username, String password);

// native 쿼리 전략
// @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
// User login(String username, String password);
