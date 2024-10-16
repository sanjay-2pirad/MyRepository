package org.example.service;

import org.example.filter.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class EmployeeJmsListener {

    private List<String> messages = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    @JmsListener(destination = "employee.queue")
    public void receiveMessage(String message) {
        logger.info("Receiving message");
        messages.add(message);
    }

    public List<String> getMessages() {
        logger.info("This block gets the message" +messages);
        return messages;
    }
}

