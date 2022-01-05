package com.ksa.project.controller;

import com.ksa.project.model.Book;
import com.ksa.project.model.BookDiary;
import com.ksa.project.model.Orders;
import com.ksa.project.model.User;
import com.ksa.project.repository.BookRepository;
import com.ksa.project.repository.OrdersRepository;
import com.ksa.project.repository.UserRepository;
import com.ksa.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mypage")
@CrossOrigin
public class MyPageController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    //UserInfo update
    @PostMapping({"/userProfile"})
    public User editUser(String userId, String userPassword){
        System.out.println(userId+userPassword);
        User findUser = userRepository.findByEmailAndPassword(userId, userPassword);
        return findUser;
    }
    //UserInfo update
    @PostMapping("/userUpdate")
    public Map<String,Object> editUser(String userId, String userPassword, User user){
        System.out.println(userId+","+userPassword+":"+user);
        User findUser = userRepository.findByEmailAndPassword(userId, userPassword);
        HashMap<String,Object> map=new HashMap<>();
        if (findUser!=null){
            findUser.setPassword(user.getPassword());
            findUser.setAddress1(user.getAddress1());
            findUser.setAddress2(user.getAddress2());
            findUser.setPostcode(user.getPostcode());
            findUser.setPhone(user.getPhone());
            map.put("result","success");
            map.put("code",200);
            map.put("user",findUser);
            userRepository.save(findUser);
        }else{
            map.put("result","fail to update user's information");
            map.put("code",400);
        }
        return map;
    }

    @GetMapping("/diary/write")
    public Book writeDiary(Long bookId,String userId, String userPassword ){
        bookId=1L;
        Book book=bookRepository.findById(bookId).get();

        return book;

    }

    @PostMapping("/diary/write")
    public Map<String,Object> writeDiary(Long bookId, String userId, String userPassword, BookDiary bookDiary){
        HashMap<String,Object> map=new HashMap<>();
        bookId=1L;
        Book book=bookRepository.findById(bookId).get();
        User findUser = userRepository.findByEmailAndPassword(userId, userPassword);
        bookDiary.setUser(findUser);
        return map;
    }

    @PostMapping("/orders/list")
    public List<Orders> showOrderList(String userId, String userPassword){
        return orderService.showOrderList(userId,userPassword);
    }

}
