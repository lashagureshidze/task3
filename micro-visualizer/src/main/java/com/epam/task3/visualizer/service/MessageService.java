package com.epam.task3.visualizer.service;

import com.epam.task3.visualizer.domain.MessageEntity;
import com.epam.task3.visualizer.domain.MessageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;

    public Page<String> getSavedMessages(Pageable pageable) {
        return messageRepo.findAll(pageable)
                .map(MessageEntity::getMessage);
    }
}
