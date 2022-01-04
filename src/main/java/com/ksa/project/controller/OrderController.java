package com.ksa.project.controller;

import com.ksa.project.repository.OrdersBookRepository;
import com.ksa.project.repository.OrdersRepository;
import com.ksa.project.repository.UserRepository;
import com.ksa.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;



}
