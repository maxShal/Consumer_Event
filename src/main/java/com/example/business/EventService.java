package com.example.business;

import com.example.db.EventChangeNotificationEntity;
import com.example.db.EventRepository;
import com.example.mapper.NotificationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final NotificationMapper mapper;

    public EventService(EventRepository repository, NotificationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EventChangeNotification> getNotifications(Long useId)
    {
        return repository.findByIsReadFalseAndUserId(useId).stream()
                .map(mapper::toModel)
                .toList();
    }

    public List<Long> readNotifications(Long userId)
    {
        List<EventChangeNotificationEntity> entities = repository.findByIsReadFalseAndUserId(userId);
        return  entities.stream().map(EventChangeNotificationEntity::getEventId).toList();
    }
}
