package com.example.RechargeApp.controller;


import com.example.RechargeApp.model.Notification;
import com.example.RechargeApp.NotificationProducer;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendNotification(@RequestBody Notification event) {
        producer.sendNotification(event);
        return "Message sent!";
    }
}
