package com.epam.task3.recipient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class MicroRecipientApplication {

    public static final String QUEUE_NAME = "notifications";

    public static void main(String[] args) {
        SpringApplication.run(MicroRecipientApplication.class, args);
    }
}
