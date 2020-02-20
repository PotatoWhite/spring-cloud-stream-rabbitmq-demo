package me.potato.demo.rabbitmq.simplesubscriber.listener;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding(Sink.class)
@Component
public class SimpleListener {

    @Async
    @StreamListener(Sink.INPUT)
    public void on(Message message){
        log.info("Receive : {}", message.toString());
    }


}

