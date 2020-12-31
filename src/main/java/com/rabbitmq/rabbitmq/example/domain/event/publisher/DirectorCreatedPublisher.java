package com.rabbitmq.rabbitmq.example.domain.event.publisher;

import com.rabbitmq.rabbitmq.example.domain.event.Channel;
import com.rabbitmq.rabbitmq.example.domain.event.model.DirectorCreatedEvent;
import com.rabbitmq.rabbitmq.example.domain.event.model.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DirectorCreatedPublisher {
    private final Channel channel;

    public void publish(DirectorCreatedEvent event) {
        log.info("DirectorCreatedEvent has been created {}", event);
        channel.messagingOutputChannel().send(Event.getEventMessage(event));
    }
}
