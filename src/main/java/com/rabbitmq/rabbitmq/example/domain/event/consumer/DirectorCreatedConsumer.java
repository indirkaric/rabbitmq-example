package com.rabbitmq.rabbitmq.example.domain.event.consumer;

import com.rabbitmq.rabbitmq.example.domain.event.model.DirectorCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DirectorCreatedConsumer {
    @StreamListener(target = "messaging-channel",
            condition = "headers['eventType']=='directorcreatedevent'")
    public void listen(DirectorCreatedEvent event) {
        log.info("Event received {} ", event);
    }
}
