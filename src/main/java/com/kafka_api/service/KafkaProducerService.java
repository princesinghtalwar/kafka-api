package com.kafka_api.service;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.util.concurrent.ListenableFuture;

import com.kafka_api.dto.GenericMessage;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic = "generic-topic";

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    public ListenableFuture<?> send(GenericMessage message) {
//        String key = message.getId() != null ? message.getId() : UUID.randomUUID().toString();
//        return kafkaTemplate.send(topic, key, message);
//    }
    
    public void send(GenericMessage message) {
        kafkaTemplate.send(topic, message.getId(), message);
    }

}
