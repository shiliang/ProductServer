package com.product.server.message;

import com.product.server.domain.impl.OrderCreated;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "order-trans", consumerGroup = "txOrder")
public class OrderTransactionConsumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println("消息收到");
    }
}
