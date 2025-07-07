package com.example.business;

import com.example.db.EventRepository;
import com.example.mapper.EventMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;

    public EventService(EventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Event> getEvent()
    {
        return repository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }

    public List<Long> readEvent(List<Event> events)
    {
        events.forEach(event -> event.setRead(true));
        repository.saveAll(events.stream().map(mapper::toEntity).toList());
        return events.stream()
            .map(Event::getEventId)
            .toList();
    }
}
