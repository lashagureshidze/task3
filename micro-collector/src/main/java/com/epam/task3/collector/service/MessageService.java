package com.epam.task3.collector.service;

import com.epam.task3.collector.domain.MessageEntity;
import com.epam.task3.collector.domain.MessageRepo;
import com.epam.task3.collector.feign.RecipientClient;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MessageService {
    private final AtomicInteger metric;
    private final RecipientClient recipientClient;
    private final MessageRepo messageRepo;

    public MessageService(RecipientClient recipientClient, MessageRepo messageRepo, MeterRegistry meterRegistry) {
        this.recipientClient = recipientClient;
        this.messageRepo = messageRepo;

        //custom metrics
        this.metric = meterRegistry.gauge("custom_metric_micro-collector", new AtomicInteger(0));
    }

    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void getMessages() {
        List<String> messages = recipientClient.getMessages();
        log.info("got messages from micro-recipient=({})", messages);

        //save to DB
        if (!messages.isEmpty()) {
            messageRepo.saveAll(
                    messages.stream()
                            .map(m -> new MessageEntity(m))
                            .collect(Collectors.toList()));
        }

        //randomize metric
        metric.set(new Random().nextInt(100));
    }
}
