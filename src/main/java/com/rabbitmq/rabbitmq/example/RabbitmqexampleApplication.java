package com.rabbitmq.rabbitmq.example;

import com.rabbitmq.rabbitmq.example.domain.event.Channel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = {Channel.class})
@SpringBootApplication
public class RabbitmqexampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqexampleApplication.class, args);
    }

}
