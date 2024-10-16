package com.example.orderprocessing.controller;

import com.example.orderprocessing.model.Order;
import com.example.orderprocessing.repository.OrderRepository;
import com.example.orderprocessing.services.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JmsProducer jmsProducer;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        String message = "Order ID: " + savedOrder.getId() + ", Product: " + savedOrder.getProductName() + ", Quantity: " + savedOrder.getQuantity();
        jmsProducer.sendToInventoryService(message);
        jmsProducer.sendToBillingService(message);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

