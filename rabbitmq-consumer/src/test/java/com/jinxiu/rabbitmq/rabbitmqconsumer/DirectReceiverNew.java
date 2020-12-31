package com.jinxiu.rabbitmq.rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * 配置多台监听绑定到同一个直连交互的同一个队列时，采用轮询，不存在重复消费
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiverNew {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者2收到消息  : " + testMessage.toString());
    }

}
