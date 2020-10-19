package com.fendou.mq;

import com.fendou.cjx.RocketMQService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cjx
 * @Date: 2020-10-19 14:43
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RocketMQService.class)
public class RocketMqTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test1(){
        rocketMQTemplate.convertAndSend("rocketmq","hello springboot rocketmq");

    }
}
