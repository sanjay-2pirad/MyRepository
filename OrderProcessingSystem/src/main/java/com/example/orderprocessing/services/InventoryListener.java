package com.example.orderprocessing.services;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryListener {

    @JmsListener(destination = "inventory.queue")
    public void onOrderReceived(String message) {
        System.out.println("Inventory Service: Updating stock for order - " + message);
    }
}

