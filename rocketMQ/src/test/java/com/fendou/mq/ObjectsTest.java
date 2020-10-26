package com.fendou.mq;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: cjx
 * @Date: 2020-10-21 10:01
 * @Description;
 */
public class ObjectsTest {
    @Test
    public void test1(){
     String a=null;
//        Objects.requireNonNull(a,"123");
//        System.err.println("empty===>"+StringUtils.isNotEmpty(a));
//        System.err.println("blank===>"+StringUtils.isNotBlank(a));
        Assert.assertNotNull("123",a);
    }
}
