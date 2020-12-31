package com.rabbitmq.rabbitmq.example.domain.event.model;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.Serializable;

public class Event implements Serializable{
    public static <T> Message<T> getEventMessage(T model) {
        return MessageBuilder
                .withPayload(model)
                .setHeader("eventType", model.getClass().getSimpleName().toLowerCase())
                .build();
    }
}
