# SpringBoot-RabbitMQ-Demo

本项目旨在演示如何使用Spring Boot和RabbitMQ构建生产者-消费者模型，以实现消息的发送和接收。

## 项目结构
    spring-boot-rabbitmq-demo/
    ├── src/                    <-- 项目源代码
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── oven/
    │   │   │           ├── Application.java     <-- Spring Boot应用程序入口
    │   │   │           ├── controller/
    │   │   │           │   └── DemoController.java   <-- 控制器类
    │   │   │           ├── producer/
    │   │   │           │   └── RabbitMQProducer.java     <-- RabbitMQ生产者类
    │   │   │           └── consumer/
    │   │   │               └── RabbitMQConsumer.java     <-- RabbitMQ消费者类
    │   │   └── resources/
    │   │       └── application.properties   <-- 应用程序配置文件
    └── pom.xml                 <-- Maven项目配置文件
## 特性
- 使用SpringBoot集成 RabbitMQ发送和接收消息
- 将消息内容格式化为JSON

## 环境要求
- Java 11或更高版本
- RabbitMQ 3.9.21
- Spring Boot 2.7.6

## 使用方法
- 启动RabbitMQ服务
- 运行Spring Boot应用程序：
```bash
mvn spring-boot:run
```

### 发送消息示例
- 你可以使用HTTP POST请求发送消息：
```bash
curl -X POST http://localhost:8080/send?msg=HelloWorld
```
- 命令行输出：
```
$ curl -X POST http://localhost:8080/send?msg=HelloWorld
发送消息成功：
{
  "producerId" : "num1",
  "message" : "HelloWorld",
  "timestamp" : "Wed Oct 11 20:26:28 CST 2023",
  "queue" : "test"
}
```
- SpringBoot端输出：
```
消费者接收到消息：
{
  "producerId" : "num1",
  "message" : "HelloWorld",
  "timestamp" : "Wed Oct 11 20:26:28 CST 2023",
  "queue" : "test"
}
```





