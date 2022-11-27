package com.example.springconsumer.configuration;

import com.example.springconsumer.model.SkiEvent;
import com.example.springconsumer.model.SkiEventPOJO;
import com.example.springconsumer.service.SkiEventService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class MessageConsumerService implements MessageListener {

    final SkiEventService skiEventService;

    public MessageConsumerService(SkiEventService skiEventService) {
        this.skiEventService = skiEventService;
    }


    //    @Async
    public CompletableFuture<SkiEvent> persistSkiEvent(String messageBody) {
        Gson gson = new Gson();
        SkiEventPOJO skiEventPOJO = gson.fromJson(messageBody, SkiEventPOJO.class);
        SkiEvent skiEvent = skiEventService.createSkiEvent(skiEventPOJO);
        return CompletableFuture.completedFuture(skiEvent);
    }

    @Override
    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        persistSkiEvent(messageBody);
    }
}
