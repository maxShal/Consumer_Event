package com.example.web;


import com.example.business.EventChangeNotification;
import com.example.business.EventService;
import com.example.exceptoin.ErrorMessageResponse;
import com.example.mapper.NotificationMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/notifications")
public class EventController {

    private final NotificationMapper mapper;
    private final EventService service;

    public EventController(NotificationMapper mapper, EventService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EventChangeNotificationDto>> getNotifications(@AuthenticationPrincipal Jwt jwt)
    {

        Long userId = Long.valueOf(jwt.getClaim("sub").toString());
        List<EventChangeNotification> notifications = service.getNotifications(userId);
        return new ResponseEntity<>(notifications.stream().map(mapper::toDto).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> readNotifications(@AuthenticationPrincipal Jwt jwt, @RequestBody NotificationRequest request) {
        Long userId = Long.valueOf(jwt.getClaim("sub").toString());
        service.readNotifications(userId, request.getNotificationIds());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
