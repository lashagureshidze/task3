package com.epam.task3.sender.service;

import com.epam.task3.sender.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.epam.task3.sender.MicroSenderApplication.QUEUE_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    public void sendNotification(Notification notification) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, notification.getMessage());
    }
}
