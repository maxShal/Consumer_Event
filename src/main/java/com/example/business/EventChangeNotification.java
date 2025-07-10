package com.example.business;

import com.example.db.FieldChange.FieldChangeDateTime;
import com.example.db.FieldChange.FieldChangeDecimal;
import com.example.db.FieldChange.FieldChangeInteger;
import com.example.db.FieldChange.FieldChangeString;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
public class EventChangeNotification {


    private Long eventId;

    private boolean isRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();


    private FieldChangeString name;

    private FieldChangeInteger maxPlaces;

    private FieldChangeDateTime date;

    private FieldChangeDecimal cost;

    private FieldChangeInteger duration;

    private FieldChangeInteger locationId;


    public EventChangeNotification(Long eventId, boolean isRead, LocalDateTime createdAt, FieldChangeString name, FieldChangeInteger maxPlaces, FieldChangeDateTime date, FieldChangeDecimal cost, FieldChangeInteger duration, FieldChangeInteger locationId) {
        this.eventId = eventId;
        this.isRead = isRead;
        this.createdAt = createdAt;
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
    }
}