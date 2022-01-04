package com.ksa.project.service;

import com.ksa.project.model.User;
import com.ksa.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl {
    @Autowired
    UserRepository userRepository;

    public User emailCheck(String email) throws Exception {
        User result = userRepository.findByEmail(email);
        return result;
    }
};

