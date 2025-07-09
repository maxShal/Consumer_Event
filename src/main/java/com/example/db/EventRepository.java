package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    void deleteByCreatedAtBefore(LocalDateTime dateTime);

}
