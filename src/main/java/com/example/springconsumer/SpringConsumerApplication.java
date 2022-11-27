package com.example.springconsumer;

import com.example.springconsumer.configuration.MessageConsumerService;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class SpringConsumerApplication {
    public static final String QUEUE_NAME = "skiEvent";

    @Bean
    Queue queue() {
        Queue queue = new Queue(QUEUE_NAME);
        return queue;
    }

    @Bean
    MessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageConsumerService) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setConcurrentConsumers(32);
        container.setMaxConcurrentConsumers(64);
        container.setConsecutiveActiveTrigger(1);
        container.setStartConsumerMinInterval(100);
        container.setQueues(queue());
        container.setMessageListener(messageConsumerService);
        return container;
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(System.getenv("RABBIT_MQ"));
        cachingConnectionFactory.setChannelCacheSize(100);
        cachingConnectionFactory.setUsername("test");
        cachingConnectionFactory.setPassword("test");
        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageConsumerService messageConsumerService) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(messageConsumerService);
        messageListenerAdapter.containerAckMode(AcknowledgeMode.AUTO);
        return messageListenerAdapter;
    }

    //    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("SkiEventThread-");
        executor.initialize();
        return executor;

    }


    public static void main(String[] args) {
        SpringApplication.run(SpringConsumerApplication.class, args);
    }

}
