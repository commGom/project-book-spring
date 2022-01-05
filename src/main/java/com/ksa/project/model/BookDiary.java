package com.ksa.project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class BookDiary {
    @Id @GeneratedValue
    private long id;
    @CreationTimestamp
    private LocalDateTime writtenDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    private String content;
    private String thought;
    private String title;
    @OneToOne
    private Book book;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "bookDiary")
    FileAttach fileAttach;
}
