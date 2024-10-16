package com.example.orderprocessing.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BillingListener {

    @JmsListener(destination = "billing.queue")
    public void onOrderReceived(String message) {
        System.out.println("Billing Service: Creating invoice for order - " + message);
    }
}
