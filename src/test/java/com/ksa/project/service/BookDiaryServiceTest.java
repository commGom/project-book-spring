package com.ksa.project.service;

import com.ksa.project.model.Book;
import com.ksa.project.model.BookDiary;
import com.ksa.project.model.Orders;
import com.ksa.project.model.User;
import com.ksa.project.repository.BookDiaryRepository;
import com.ksa.project.repository.BookRepository;
import com.ksa.project.repository.OrdersRepository;
import com.ksa.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
//@Transactional
class BookDiaryServiceTest {
    @Autowired
    BookDiaryService bookDiaryService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Test
    void writeDiary() {
        User findUser = userRepository.findByEmail("phyw1129@naver.com");
        List<Orders> orderList = ordersRepository.findByUser(findUser);
        Long bookId=1L;
        for (Orders orders : orderList) {
            bookId=orders.getBook().getId();
            BookDiary bookDiary=BookDiary.builder()
                    .title("제목!!"+bookId)
                    .content("내용~~"+bookId)
                    .thought("내 생각~~~~~"+bookId)
                    .build();
            bookDiaryService.writeDiary(findUser.getId(), bookId, bookDiary);
        }

    }

    @Test
    void diaryList() {
        User findUser = userRepository.findByEmail("phyw1129@naver.com");
        List<BookDiary> bookDiaries = bookDiaryService.diaryList(findUser.getId());
        log.info("diaryList Test 실시~~~~~~");
        log.info(bookDiaries.toString());
    }

    @Test
    void diaryDetail() {
        Long diaryId=1L;
        BookDiary bookDiary = bookDiaryService.diaryDetail(diaryId);
        log.info(bookDiary.toString());


    }

    @Test
    void deleteDiary() {
        Long diaryId=1L;
        bookDiaryService.deleteDiary(diaryId);
    }

    @Test
    void updateDiary() {
        BookDiary bookDiary=BookDiary.builder()
                .title("수정 제목")
                .thought("수정 생각")
                .content("수정 내용")
                .build();
        bookDiary.setId(1L);
        bookDiaryService.updateDiary(bookDiary);
    }
}