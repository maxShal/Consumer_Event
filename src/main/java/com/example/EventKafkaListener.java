package com.example;

import com.example.web.KafkaChangeEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class EventKafkaListener {
    private static final Logger log = LoggerFactory.getLogger(EventKafkaListener.class);

    @KafkaListener(topics = "event-topic",containerFactory = "containerFactory")
    public void listenEvents(
            ConsumerRecord<Long, KafkaChangeEvent> record
    ){
        log.info("get event={}", record.value());
    }
}
