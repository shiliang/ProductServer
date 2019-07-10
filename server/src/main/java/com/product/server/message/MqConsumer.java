package com.product.server.message;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "order", consumerGroup = "mygroup")
public class MqConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("收到消息:" + s);
    }
}
