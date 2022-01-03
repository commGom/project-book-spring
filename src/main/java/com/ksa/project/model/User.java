package com.ksa.project.model;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id @GeneratedValue
    private long id;
    private String email;
    private String password;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    private String phone;
    private String address;
    @CreationTimestamp
    private LocalDateTime createdDate;
};
