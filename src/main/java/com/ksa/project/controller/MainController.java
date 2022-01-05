package com.ksa.project.controller;

import com.ksa.project.repository.BookRepository;
import com.ksa.project.service.BookService;
import com.ksa.project.model.Book;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("/")
@CrossOrigin
public class MainController {
  @Autowired
  BookRepository bookRepository;

  @GetMapping("/mainList")
  public List<Book> showAllBookList(Model model){
      int count = 10;
      List<Book> temp = bookRepository.findAll();
      Collections.shuffle(temp);
      List<Book> result = temp.subList(0, count);
      return result;
  }
  
}
