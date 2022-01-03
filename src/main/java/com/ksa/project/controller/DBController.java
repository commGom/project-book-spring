package com.ksa.project.controller;

import java.util.List;

import com.ksa.project.model.Demo;
import com.ksa.project.repository.DemoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class DBController {
    @Autowired
    DemoRepository demoRepository;

    @GetMapping("/jpa/demo")
    public List<Demo> jpaDemo() {
        return demoRepository.findAll();
    }
};
