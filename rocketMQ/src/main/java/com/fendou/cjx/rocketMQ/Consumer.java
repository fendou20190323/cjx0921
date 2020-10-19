package com.fendou.cjx.rocketMQ;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @Date: 2020-10-19 14:25
 * @Description;
 */
@RocketMQMessageListener(topic="rocketmq",consumerGroup = "${rocketmq.producer.group}")
@Component
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.err.println(s);
    }
}
