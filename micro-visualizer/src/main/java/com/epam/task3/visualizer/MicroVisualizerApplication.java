package com.epam.task3.visualizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroVisualizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroVisualizerApplication.class, args);
    }
}
