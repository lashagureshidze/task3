package com.epam.task3.recipient.service;

import com.epam.task3.recipient.utils.MessageDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.epam.task3.recipient.MicroRecipientApplication.QUEUE_NAME;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 2000)
    public void readMessage() {
        String message = null;
        try {
            message = (String) rabbitTemplate.receiveAndConvert(QUEUE_NAME);
        } catch (Exception e) {
            //ignore startup exception when queue is not exists yet
            return;
        }
        if (message == null) return;

        log.info("received message:({})", message);
        MessageDB.addMessage(message);
    }
}
