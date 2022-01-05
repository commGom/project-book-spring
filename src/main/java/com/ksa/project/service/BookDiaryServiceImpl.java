package com.ksa.project.service;

import com.ksa.project.model.Book;
import com.ksa.project.model.BookDiary;
import com.ksa.project.model.User;
import com.ksa.project.repository.BookDiaryRepository;
import com.ksa.project.repository.BookRepository;
import com.ksa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class BookDiaryServiceImpl implements BookDiaryService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDiaryRepository bookDiaryRepository;

    @Override
    public BookDiary writeDiary(Long user_id, Long book_id, BookDiary bookDiary) {
        User findUser = userRepository.findById(user_id).get();
        Book book = bookRepository.findById(book_id).get();
        bookDiary.setBook(book);
        bookDiary.setUser(findUser);

        BookDiary saveDiary = bookDiaryRepository.save(bookDiary);
        return saveDiary;
    }

    @Override
    public List<BookDiary> diaryList(Long userId) {
        User findUser = userRepository.findById(userId).get();

        List<BookDiary> diaryList = bookDiaryRepository.findByUser(findUser);
        return diaryList;
    }

    @Override
    public BookDiary diaryDetail(Long id) {
        BookDiary bookDiary = bookDiaryRepository.findById(id).get();
        return bookDiary;
    }

    @Override
    public void deleteDiary(Long id) {
        bookDiaryRepository.deleteById(id);
    }

    @Override
    public BookDiary updateDiary(BookDiary bookDiary) {
        BookDiary findDiary = bookDiaryRepository.findById(bookDiary.getId()).get();
        findDiary.setContent(bookDiary.getContent());
        findDiary.setThought(bookDiary.getThought());
        findDiary.setTitle(bookDiary.getTitle());
        BookDiary save = bookDiaryRepository.save(findDiary);
        return save;
    }
}
