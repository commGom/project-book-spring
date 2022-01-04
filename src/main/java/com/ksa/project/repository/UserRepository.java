package com.ksa.project.repository;

import com.ksa.project.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
   
    public User findByEmailAndPassword(String email, String password);
    // 아이디 및 이름 중복 체크
    public User findByEmail(String email);
};
