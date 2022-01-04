package com.ksa.project.service;

import com.ksa.project.model.User;

public interface OrderService {
    //책 주문하기 (구매(결제) 하기 전 order_state=결제대기)
    void Orders(String userId, String userPassword, User user);
}
