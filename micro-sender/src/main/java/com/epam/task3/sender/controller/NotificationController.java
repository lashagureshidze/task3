package com.epam.task3.sender.controller;

import com.epam.task3.sender.model.Notification;
import com.epam.task3.sender.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<Void> sendNotification(@RequestBody @Validated Notification notification) {
        log.info("sending message:({})", notification);

        notificationService.sendNotification(notification);
        return ResponseEntity.ok().build();
    }
}
