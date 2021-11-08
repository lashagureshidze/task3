package com.epam.task3.visualizer.controller;

import com.epam.task3.visualizer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/saved-messages")
    public ResponseEntity<Page<String>> getSavedMessages(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {


        return ResponseEntity.ok(
                messageService.getSavedMessages(
                        PageRequest.of(
                                page != null ? page : 0,
                                size != null ? size : Integer.MAX_VALUE)));
    }
}
