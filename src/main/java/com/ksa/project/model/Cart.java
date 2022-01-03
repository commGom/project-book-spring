package com.ksa.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Cart {
    @Id @GeneratedValue
    private long id;
    private int count;
    private int cartPrice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
}
