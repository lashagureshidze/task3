package com.epam.task3.collector.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<MessageEntity, Integer> {
}
