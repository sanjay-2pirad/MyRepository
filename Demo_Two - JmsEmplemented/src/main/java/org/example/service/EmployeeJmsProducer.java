package org.example.service;

import org.example.entity.Employee;
import org.example.filter.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJmsProducer {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendEmployeeCreatedMessage(Employee employee) {
        logger.info("This block sends messages");
        String message = "Employee created with Name='" + employee.getName() + "', Age='" + employee.getAge() + "', Sex='" + employee.getSex() + "'";
        logger.info("This block sends messages" +message);
        jmsTemplate.convertAndSend("employee.queue", message);
    }
}

