package com.rabbitmq.rabbitmq.example.domain.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channel {
    @Input("messaging-channel")
    SubscribableChannel messagingInputChannel();
    @Output("messaging-channel")
    MessageChannel messagingOutputChannel();
}
