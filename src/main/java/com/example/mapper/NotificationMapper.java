package com.example.mapper;

import com.example.business.EventChangeNotification;
import com.example.db.EventChangeNotificationEntity;
import com.example.web.EventChangeNotificationDto;
import com.example.web.KafkaChangeEvent;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NotificationMapper {

    EventChangeNotificationDto toDto(EventChangeNotification model);
    EventChangeNotification toModel(KafkaChangeEvent dto);
    EventChangeNotification toModel(EventChangeNotificationEntity entity);
    //EventsEntity toEntity(Events ev);
    EventChangeNotificationEntity toEntity(EventChangeNotificationDto dto);
    EventChangeNotificationDto toRespDto(EventChangeNotification model);
    EventChangeNotificationEntity toEntity(EventChangeNotification model);
    //EventChangeNotification toModel(EventResponseDto dto);
}
