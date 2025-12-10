package com.kafka_api.consumer;

import com.kafka_api.dto.GenericMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "generic-topic", containerFactory = "kafkaListenerContainerFactory")
    public void listen(GenericMessage message, Acknowledgment ack) {
        try {
            // business processing
            System.out.println("Consumed: " + message.getId() + " / " + message.getType());
            // ack only after successful processing
            ack.acknowledge();
        } catch (Exception ex) {
            // handle error: log, metrics, send to DLQ, etc.
            // Do NOT ack if you want retry semantics via manual commit
            throw ex; // allow retry mechanism to handle it (see retry config)
        }
    }
}
