package com.ksa.project.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class BookDiary {
    @Id @GeneratedValue
    private long id;
    private String title;
    @CreationTimestamp
    private LocalDateTime writtenDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    private String content;
    private String thought;

    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "bookDiary")
    FileAttach fileAttach;
}
