package com.epam.task3.recipient.controller;

import com.epam.task3.recipient.utils.MessageDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MessageController {

    @GetMapping("/message")
    public ResponseEntity<List<String>> getMessages() {
        List<String> messages = MessageDB.getAndClearMessages();

        log.info("messages=({})", messages);
        return ResponseEntity.ok(messages);
    }
}
