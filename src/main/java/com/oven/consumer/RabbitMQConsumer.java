package com.oven.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
@RabbitListener(queues = "${spring.rabbitmq.consumer.queue}")
public class    RabbitMQConsumer {

    @RabbitHandler
    public void consumer(String message) {
        System.out.printf("消费者接收到消息：\n%s\n", message);
    }
}
