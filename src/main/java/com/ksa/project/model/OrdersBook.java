package com.ksa.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class OrdersBook {
    @Id @GeneratedValue
    private long id;
    private int orderCount;
    private int orderPrice;

    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Book book;
}
