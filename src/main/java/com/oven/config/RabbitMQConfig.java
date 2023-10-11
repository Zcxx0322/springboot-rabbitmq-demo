package com.oven.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@SuppressWarnings("unused")
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.producer.queue}")
    private String queueName;

    @Bean
    public Queue myQueue() {
        return new Queue(queueName);
    }
}