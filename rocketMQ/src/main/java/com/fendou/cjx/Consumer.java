package com.fendou.cjx;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @Date: 2020-10-19 14:25
 * @Description;
 */
@RocketMQMessageListener(topic="orderTopic",consumerGroup = "${rocketmq.producer.group}",messageModel = MessageModel.CLUSTERING)
@Component
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.err.println("2===="+s);
    }
}
