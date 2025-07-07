package com.example.mapper;

import com.example.business.Event;
import com.example.db.EventEntity;
import com.example.web.EventResponseDto;
import com.example.web.KafkaChangeEvent;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EventMapper {

    KafkaChangeEvent toKafkaEv(Event event);
    Event toModel(KafkaChangeEvent kafkaEv);
    Event toModel(EventEntity entity);
    EventEntity toEntity(Event ev);
    EventEntity toEntity(KafkaChangeEvent kafkaEv);
    EventResponseDto toRespDto(Event event);
    Event toModel(EventResponseDto dto);
}
