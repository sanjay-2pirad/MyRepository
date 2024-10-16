package com.example.orderprocessing.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendToInventoryService(String message) {
        jmsTemplate.convertAndSend("inventory.queue", message);
    }

    public void sendToBillingService(String message) {
        jmsTemplate.convertAndSend("billing.queue", message);
    }
}
