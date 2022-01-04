package com.ksa.project.repository;

import com.ksa.project.model.OrdersBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersBookRepository extends JpaRepository<OrdersBook,Long> {
}
