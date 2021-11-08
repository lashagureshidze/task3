package com.epam.task3.collector.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "messages")
@Entity
@NoArgsConstructor
public class MessageEntity {

    public MessageEntity(String message) {
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer id;

    @Column(name = "message")
    private String message;
}
