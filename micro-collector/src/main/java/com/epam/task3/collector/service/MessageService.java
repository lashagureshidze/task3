package com.epam.task3.collector.service;

import com.epam.task3.collector.feign.RecipientClient;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class MessageService {
    private final AtomicInteger metric;
    private final RecipientClient recipientClient;

    public MessageService(RecipientClient recipientClient, MeterRegistry meterRegistry) {
        this.recipientClient = recipientClient;
        this.metric = meterRegistry.gauge("custom_metric_micro-collector", new AtomicInteger(0));
    }

    @Timed(value = "get_messages_scheduler_custom_metrics")
    @Scheduled(fixedRate = 5000)
    public void getMessages() {
        List<String> messages = recipientClient.getMessages();
        log.info("got messages from micro-recipient=({})", messages);

        //randomize metric
        metric.set(new Random().nextInt(100));
    }
}
