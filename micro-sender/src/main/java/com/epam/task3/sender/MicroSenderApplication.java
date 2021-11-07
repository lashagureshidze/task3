package com.epam.task3.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroSenderApplication {

    public static final String QUEUE_NAME = "notifications";

    public static void main(String[] args) {
        SpringApplication.run(MicroSenderApplication.class, args);
    }

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
