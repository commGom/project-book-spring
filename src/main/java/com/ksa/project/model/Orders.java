package com.ksa.project.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class Orders {
    @Id @GeneratedValue
    private long id;
    @CreationTimestamp
    private LocalDateTime orderDate;
    private String payMethod;
    private int totalPrice;
    private String orderState;
    private String orderAddress;
    @ManyToOne
    private User user;
}
