package com.example;

import com.example.db.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@Configuration
public class EventStatusScheduledUpdater {

    private final static Logger log = LoggerFactory.getLogger(EventStatusScheduledUpdater.class);

    private final EventRepository eventRepository;

    public EventStatusScheduledUpdater(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Scheduled(cron = "${eventChangeNotification.stats.cron}")
    public void deleteEvent(){
        log.info("EventStatusScheduledUpdater started");
        LocalDateTime cutoff = LocalDateTime.now().minusDays(7);
        eventRepository.deleteByCreatedAtBefore(cutoff);
    }

}
