package me.potato.demo.rabbitmq.simplepublisher.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class PublisherController {

    private final Source source;

    public PublisherController(Source source) {
        this.source = source;
    }

    @GetMapping("/api/pub")
    public void publish() {
        Message message = new Message("Hello RabbitMQ World");
        source.output().send(MessageBuilder.withPayload(message).build());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Message {
        private String message;
    }
}
