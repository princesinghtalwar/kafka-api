package com.kafka_api.controller;

import com.kafka_api.dto.GenericMessage;
import com.kafka_api.service.KafkaProducerService;
import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final KafkaProducerService producerService;

    public MessageController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<?> publish(@RequestBody GenericMessage request) {
        if (request.getCreatedAt() == null) {
            request.setCreatedAt(Instant.now());
        }
        producerService.send(request).addCallback(
            result -> {}, // success handler (log or metrics)
            ex -> {}      // failure handler (log, escalate)
        );
        return ResponseEntity.accepted().build();
    }
}
