package com.fendou.cjx.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cjx
 * @Date: 2020-10-26 10:24
 * @Description;
 */
@RequestMapping("/rmq")
@RestController
public class RocketMQTestController {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Value("${mq.order.topic}")
    private String topic;

    @Value("${mq.order.tag.cancel}")
    private String tag;
    @GetMapping("/test")
    public String testMq(String a) throws Exception {
        Message message = new Message(topic,"body".getBytes());
        rocketMQTemplate.getProducer().send(message);
        return "success";
    }
}
