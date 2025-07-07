package com.example.db;

import com.example.web.EventStatus;
import com.example.web.FieldChange;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class EventEntity {

    @Id
    private Long eventId;

    private boolean isRead = false;

    private final List<Long> users;

    private final Long ownerId;

    private final Long changedById;


    private FieldChange<String> name;
    private FieldChange<Integer> maxPlaces;
    private FieldChange<LocalDateTime> date;
    private FieldChange<Integer> cost;
    private FieldChange<Integer> duration;
    private FieldChange<Long> locationId;
    private FieldChange<EventStatus> status;


/*
public KafkaChangeEvent(List<Long> users, Long ownerId, Long changedById) {
    this.users = users;
    this.ownerId = ownerId;
    this.changedById = changedById;
}*/

    public EventEntity(Long eventId, List<Long> users, Long ownerId, Long changedById, FieldChange<String> name, FieldChange<Integer> maxPlaces, FieldChange<LocalDateTime> date, FieldChange<Integer> cost, FieldChange<Integer> duration, FieldChange<Long> locationId, FieldChange<EventStatus> status) {
        this.eventId = eventId;
        this.users = users;
        this.ownerId = ownerId;
        this.changedById = changedById;
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
        this.status = status;
    }

}
