package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventChangeNotificationEntity, Long> {

    List<EventChangeNotificationEntity> findByUserId(Long userId);
    List<EventChangeNotificationEntity> findByEventIdIn(List<Long> eventIds);
    List<EventChangeNotificationEntity> findByIsReadFalseAndUserId(Long userId);
    void deleteByCreatedAtBefore(LocalDateTime dateTime);

}
