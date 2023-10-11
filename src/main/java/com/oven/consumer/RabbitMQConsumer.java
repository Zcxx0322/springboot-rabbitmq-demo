package com.oven.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
@RabbitListener(queues = "${spring.rabbitmq.consumer.queue}")
public class RabbitMQConsumer {

    @Value("${spring.rabbitmq.consumer.queue}")
    private String queueName;

    @RabbitHandler
    public void consumer(String message) {
        System.out.printf("消费者接收到消息：\n%s\n", message, queueName);
    }
}
