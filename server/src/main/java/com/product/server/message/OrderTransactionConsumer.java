package com.product.server.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.common.DecreaseStockInput;
import com.product.server.domain.impl.OrderCreated;
import com.product.server.entity.ConsumerMsg;
import com.product.server.repository.MessageRepository;
import com.product.server.service.ProductService;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RocketMQMessageListener(topic = "order-trans", consumerGroup = "txOrder")
public class OrderTransactionConsumer implements RocketMQListener<MessageExt> {

    @Autowired
    private ProductService productService;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println("消息收到");
        ObjectMapper mapper = new ObjectMapper();
        OrderCreated event = null;
        //消息幂等处理,把消息的id插入本地的表，id列设为唯一，如果报错
        try {
            ConsumerMsg consumerMsg = new ConsumerMsg();
            consumerMsg.setOrder_msg(messageExt.getTransactionId());
            messageRepository.save(consumerMsg);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            event = mapper.readValue((byte[]) messageExt.getBody(), OrderCreated.class);
            List<DecreaseStockInput> decreaseStockInputs = event.getDecreaseStockInputs();
            //扣库存
            productService.decreaseStock(decreaseStockInputs);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
