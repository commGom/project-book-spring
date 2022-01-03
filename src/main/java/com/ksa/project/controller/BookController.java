package com.ksa.project.controller;

import com.ksa.project.model.Book;
import com.ksa.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<Book> showAllBookList(){
        return bookService.showBookList();
    }
}
