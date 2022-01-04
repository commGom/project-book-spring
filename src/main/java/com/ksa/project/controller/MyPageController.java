package com.ksa.project.controller;

import com.ksa.project.model.Book;
import com.ksa.project.model.BookDiary;
import com.ksa.project.model.User;
import com.ksa.project.repository.BookRepository;
import com.ksa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mypage")
@CrossOrigin
public class MyPageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    //UserInfo update
    @GetMapping({"/userProfile","/userUpdate"})
    public User editUser(String userId, String userPassword){
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
            findUser.setAddress(user.getAddress());
            findUser.setPhone(user.getPhone());
            map.put("result","success");
            map.put("code","200");
            map.put("user",findUser);
            userRepository.save(findUser);
        }else{
            map.put("result","fail to update user's information");
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

}
