package com.ksa.project.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

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
    private LocalDate birth;
    private String phone;
    private String address;
    @CreatedDate
    private LocalDateTime createdDate;
}