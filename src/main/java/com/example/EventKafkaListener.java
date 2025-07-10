package com.example;

import com.example.business.EventChangeNotification;
import com.example.db.EventChangeNotificationEntity;
import com.example.db.EventRepository;
import com.example.mapper.NotificationMapper;
import com.example.web.KafkaChangeEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class EventKafkaListener {
    private static final Logger log = LoggerFactory.getLogger(EventKafkaListener.class);

    private final EventRepository eventRepository;
    private final NotificationMapper mapper;

    public EventKafkaListener(EventRepository eventRepository, NotificationMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "event-topic",containerFactory = "containerFactory")
    public void listenEvents(
            ConsumerRecord<Long, KafkaChangeEvent> record
    ){
        KafkaChangeEvent kafkaEvent = record.value();
        log.info("get event={}", record.value());

        for (Long userId : kafkaEvent.getUsers()) {
            EventChangeNotification notification = mapper.toModel(kafkaEvent);
            EventChangeNotificationEntity entity = mapper.toEntity(notification);
            entity.setUserId(userId);
            eventRepository.save(entity);
        }
    }
}
