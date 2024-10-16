package com.example.orderprocessing.repository;

import com.example.orderprocessing.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}