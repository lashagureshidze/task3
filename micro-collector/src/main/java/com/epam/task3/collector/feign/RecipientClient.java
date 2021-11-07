package com.epam.task3.collector.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "RecipientClient", url = "micro-recipient:8082")
public interface RecipientClient {

    @GetMapping("message")
    List<String> getMessages();
}
