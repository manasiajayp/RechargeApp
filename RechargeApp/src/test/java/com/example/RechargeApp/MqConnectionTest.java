package com.example.RechargeApp;


import org.apache.activemq.ActiveMQConnectionFactory;

import jakarta.jms.Connection;
import jakarta.jms.JMSException;

public class MqConnectionTest {

    public static void main(String[] args) {
        String brokerUrl = "ssl://b-78aeb502-3ad5-4ef8-aae3-0ae5c565866b-1.mq.ap-south-1.amazonaws.com:61617";
        String username = "notifuser";
        String password = "Adminpass@123";

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(username, password, brokerUrl);

        Connection connection = null;

        try {
            connection = factory.createConnection();
            connection.start();
            System.out.println("✅ Successfully connected to Amazon MQ broker!");
        } catch (JMSException e) {
            System.err.println("❌ Failed to connect to Amazon MQ broker.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
