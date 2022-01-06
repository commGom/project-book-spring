package com.ksa.project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//주문 클래스(회원은 여러번 주문할 수 있다) Orders를 통해 주문한 여러 책을 주문한다
@Entity
@Getter @Setter
public class Orders {
    @Id @GeneratedValue
    private long id;
    @CreationTimestamp
    private LocalDateTime orderDate;
    private String orderState;
    private String orderAddress;
    private int orderCount;
    private int orderPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    public static Orders createOrders(Book book, int count){
        Orders orders=new Orders();
        orders.setOrderCount(count);
        orders.setBook(book);
        orders.setOrderPrice(count*book.getPrice());
        return orders;
    }
}
