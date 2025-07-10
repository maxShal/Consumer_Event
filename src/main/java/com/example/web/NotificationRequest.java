package com.example.web;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationRequest {
    private List<Long> notificationIds;
}
