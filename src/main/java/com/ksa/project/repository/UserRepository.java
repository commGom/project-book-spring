package com.ksa.project.repository;

import java.time.LocalDate;

import com.ksa.project.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   
    public User findByEmailAndPassword(String email, String password);
    public User findByBirthAndPhone(LocalDate birth, String phone);
    public User findByAddressAndName(String address, String name);

};
