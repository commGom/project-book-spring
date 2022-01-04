package com.ksa.project.service;

import com.ksa.project.model.User;
import com.ksa.project.repository.OrdersBookRepository;
import com.ksa.project.repository.OrdersRepository;
import com.ksa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersBookRepository ordersBookRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void Orders(String userId, String userPassword, User user) {
        
    }
}
