package com.ksa.project.repository;

import com.ksa.project.model.BookDiary;
import com.ksa.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDiaryRepository extends JpaRepository<BookDiary,Long> {
    List<BookDiary> findByUser(User user);
}
