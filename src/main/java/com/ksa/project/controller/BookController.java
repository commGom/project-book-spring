package com.ksa.project.controller;

import com.ksa.project.model.Book;
import com.ksa.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/{category}")
    public List<Book> showAllBookList(Model model, @PathVariable("category") String category){
        List<Book> booklist = bookRepository.findByCategory(category);
        return booklist;
    }
}
