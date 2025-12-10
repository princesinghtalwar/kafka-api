package com.kafka_api.dto;

import java.time.Instant;

public class GenericMessage {
    private String id;
    private String type;
    private String payload;
    private Instant createdAt;

    public GenericMessage() {}

    public GenericMessage(String id, String type, String payload, Instant createdAt) {
        this.id = id;
        this.type = type;
        this.payload = payload;
        this.createdAt = createdAt;
    }
    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
