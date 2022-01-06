package com.ksa.project.service;

import com.ksa.project.model.Book;
import com.ksa.project.model.BookDiary;
import com.ksa.project.model.User;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface BookDiaryService {
    //다이어리 등록
    BookDiary writeDiary(Long user_id,Long book_id,BookDiary bookDiary);
    //다이어리 목록 조회
    List<BookDiary> diaryList(Long user_id);
    //다이어리 상세 조회
    BookDiary diaryDetail(Long id);
    //다이어리 삭제
    List<BookDiary> deleteDiary(Long id,Long userId);
    //다이어리 수정
    BookDiary updateDiary(BookDiary bookDiary);
    //다이어리 페이징 처리하여 목록 조회
    Map<String,Object> diaryListWithPaging(Long userId, int page, int pageSize);
    Map<String,Object> diaryListOrderByLastUpdateWithPaging(Long userId, int page, int pageSize);
}
