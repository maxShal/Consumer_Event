package com.example.web;


import com.example.business.Event;
import com.example.business.EventService;
import com.example.mapper.EventMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class EventController {

    private final EventMapper mapper;
    private final EventService service;

    public EventController(EventMapper mapper, EventService service) {
        this.mapper = mapper;
        this.service = service;
    }

    public List<EventResponseDto> getEvent()
    {
        return service.getEvent().stream()
                .map(mapper::toRespDto)
                .toList();
    }

    public List<Long> readEvent(List<KafkaChangeEvent> dto)
    {
        List<Event> events = dto.stream().map(mapper::toModel).toList();
         return service.readEvent(events);
    }
}
