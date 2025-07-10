package com.example.db;

import com.example.db.FieldChange.FieldChangeDateTime;
import com.example.db.FieldChange.FieldChangeDecimal;
import com.example.db.FieldChange.FieldChangeInteger;
import com.example.db.FieldChange.FieldChangeString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class EventChangeNotificationEntity {

    @Id
    private Long eventId;

    private Long userId;

    private boolean isRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "name_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "name_new"))
    })
    private FieldChangeString name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "max_places_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "max_places_new"))
    })
    private FieldChangeInteger maxPlaces;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "date_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "date_new"))
    })
    private FieldChangeDateTime date;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "cost_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "cost_new"))
    })
    private FieldChangeDecimal cost;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "duration_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "duration_new"))
    })
    private FieldChangeInteger duration;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "oldField", column = @Column(name = "location_id_old")),
            @AttributeOverride(name = "newField", column = @Column(name = "location_id_new"))
    })
    private FieldChangeInteger locationId;

    public EventChangeNotificationEntity() {
    }

    public EventChangeNotificationEntity(Long eventId, Long userId, boolean isRead, LocalDateTime createdAt, FieldChangeString name, FieldChangeInteger maxPlaces, FieldChangeDateTime date, FieldChangeDecimal cost, FieldChangeInteger duration, FieldChangeInteger locationId) {
        this.eventId = eventId;
        this.userId = userId;
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
