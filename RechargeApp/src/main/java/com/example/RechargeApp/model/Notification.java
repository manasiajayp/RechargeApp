package com.example.RechargeApp.model;

import java.io.Serializable;
import java.time.Instant;

public class Notification implements Serializable {
    private String userId;
    private String title;
    private String message;
    private boolean highPriority;
    private Instant createdAt;

    public Notification() {}

    public Notification(String userId, String title, String message, boolean highPriority, Instant createdAt) {
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.highPriority = highPriority;
        this.createdAt = createdAt;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isHighPriority() { return highPriority; }
    public void setHighPriority(boolean highPriority) { this.highPriority = highPriority; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Notification{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", highPriority=" + highPriority +
                ", createdAt=" + createdAt +
                '}';
    }
}
