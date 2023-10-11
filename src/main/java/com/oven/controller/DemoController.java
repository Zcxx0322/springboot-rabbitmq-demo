package com.oven.controller;

import com.oven.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@SuppressWarnings("unused")
@RestController
public class DemoController {

    @Autowired
    private RabbitMQProducer producer;

    @RequestMapping("/send")
    public String send(@RequestParam String msg) {
        String timestamp = new Date().toString();
        String response = String.format("发送消息成功：\n{\n  \"producerId\" : \"%s\",\n  \"message\" : \"%s\",\n  \"timestamp\" : \"%s\",\n  \"queue\" : \"%s\"\n}\n",
                producer.getProducerId(), msg, timestamp, producer.getDefaultQueue());

        // 发送消息到RabbitMQ队列
        producer.send(msg);

        return response;
    }
}