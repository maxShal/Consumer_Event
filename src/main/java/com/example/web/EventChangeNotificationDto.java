package com.example.web;

import com.example.db.FieldChange.FieldChangeDateTime;
import com.example.db.FieldChange.FieldChangeDecimal;
import com.example.db.FieldChange.FieldChangeInteger;
import com.example.db.FieldChange.FieldChangeString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EventChangeNotificationDto {


    private Long eventId;

    private FieldChangeString name;

    private FieldChangeInteger maxPlaces;

    private FieldChangeDateTime date;

    private FieldChangeDecimal cost;

    private FieldChangeInteger duration;

    private FieldChangeInteger locationId;


    public EventChangeNotificationDto(Long eventId, FieldChangeString name, FieldChangeInteger maxPlaces, FieldChangeDateTime date, FieldChangeDecimal cost, FieldChangeInteger duration, FieldChangeInteger locationId) {
        this.eventId = eventId;
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
    }
}
