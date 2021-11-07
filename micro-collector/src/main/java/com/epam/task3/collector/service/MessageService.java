package com.epam.task3.collector.service;

import com.epam.task3.collector.feign.RecipientClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {

    private final RecipientClient recipientClient;

    @Scheduled(fixedRate = 5000)
    public void getMessages() {
        List<String> messages = recipientClient.getMessages();
        log.info("got messages from micro-recipient=({})", messages);
    }
}
