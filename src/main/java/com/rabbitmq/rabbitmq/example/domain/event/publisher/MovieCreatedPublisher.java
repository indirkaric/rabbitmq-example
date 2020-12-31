package com.rabbitmq.rabbitmq.example.domain.event.publisher;

import com.rabbitmq.rabbitmq.example.domain.event.Channel;
import com.rabbitmq.rabbitmq.example.domain.event.model.Event;
import com.rabbitmq.rabbitmq.example.domain.event.model.MovieCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MovieCreatedPublisher {
    private final Channel channel;

    public void publish(MovieCreatedEvent event) {
        log.info("MovieCreatedEvent has been created {}", event);
        channel.messagingOutputChannel().send(Event.getEventMessage(event));
    }
}
