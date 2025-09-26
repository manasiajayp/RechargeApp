package com.example.RechargeApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import com.example.RechargeApp.config.JmsConfig;
import com.example.RechargeApp.model.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import jakarta.jms.Queue; // ✅ Updated

@Service
public class NotificationProducer {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    private final Queue priorityQueue;
    private final Queue nonPriorityQueue;

    public NotificationProducer(JmsTemplate jmsTemplate,
                                ObjectMapper objectMapper,
                                Queue priorityQueue,
                                Queue nonPriorityQueue) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.priorityQueue = priorityQueue;
        this.nonPriorityQueue = nonPriorityQueue;
    }

    public void sendNotification(Notification event) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(event);

            if (event.isHighPriority()) {
                jmsTemplate.convertAndSend(priorityQueue, jsonMessage, (jakarta.jms.Message message) -> {
                    message.setJMSPriority(9);
                    return message;
                });
                System.out.println("✅ Sent HIGH priority event: " + jsonMessage);
            } else {
                jmsTemplate.convertAndSend(nonPriorityQueue, jsonMessage, (jakarta.jms.Message message) -> {
                    message.setJMSPriority(4);
                    return message;
                });
                System.out.println("✅ Sent NON-priority event: " + jsonMessage);
            }

        } catch (JsonProcessingException e) {
            System.err.println("❌ Failed to serialize event, sending to DLQ");
            jmsTemplate.convertAndSend(JmsConfig.DLQ, event.toString());
        }
    }

}

