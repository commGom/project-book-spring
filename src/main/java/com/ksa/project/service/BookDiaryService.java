package com.ksa.project.service;

import com.ksa.project.model.BookDiary;

import java.util.List;

public interface BookDiaryService {
    //다이어리 등록
    BookDiary writeDiary(Long user_id,Long book_id,BookDiary bookDiary);
    //다이어리 목록 조회
    List<BookDiary> diaryList(Long user_id);
    //다이어리 상세 조회
    BookDiary diaryDetail(Long id);
    //다이어리 삭제
    void deleteDiary(Long id);
    //다이어리 수정
    BookDiary updateDiary(BookDiary bookDiary);
}