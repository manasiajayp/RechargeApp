package com.example.RechargeApp.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.jms.Queue; // ✅ Use jakarta.jms.Queue for Spring Boot 3

@Configuration
public class JmsConfig {

    public static final String PRIORITY_QUEUE = "priority.queue";
    public static final String NON_PRIORITY_QUEUE = "nonpriority.queue";
    public static final String DLQ = "dead.letter.queue";

    @Bean
    public Queue priorityQueue() {
        return new ActiveMQQueue(PRIORITY_QUEUE);
    }

    @Bean
    public Queue nonPriorityQueue() {
        return new ActiveMQQueue(NON_PRIORITY_QUEUE);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new ActiveMQQueue(DLQ);
    }
}
