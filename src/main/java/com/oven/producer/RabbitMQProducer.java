package com.oven.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("unused")
@Component
public class RabbitMQProducer {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.producer.id}")
    private String producerId;

    @Value("${spring.rabbitmq.producer.queue}")
    private String defaultQueue;

    @Value("${spring.rabbitmq.virtual-host}") // 获取virtual-host配置
    private String virtualHost;

    public void send(String message) {
        String timestamp = new Date().toString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("producerId", getProducerId());
            jsonNode.put("message", message);
            jsonNode.put("timestamp", timestamp);
            jsonNode.put("queue", defaultQueue);
            jsonNode.put("virtual-host", virtualHost);

            String messageToSend = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            amqpTemplate.convertAndSend(defaultQueue, messageToSend);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public String getProducerId() {
        return producerId;
    }

    public String getDefaultQueue() {
        return defaultQueue;
    }
}
