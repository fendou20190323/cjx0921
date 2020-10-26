package com.fendou.proxy.test;

import com.fendou.proxy.factory.ProxyFactory;
import com.fendou.proxy.service.BuyHouse;
import com.fendou.proxy.service.impl.BuyHouseImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: cjx
 * @Date: 2020-10-22 16:37
 * @Description;
 */
public class TestProxy {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        BuyHouse proxy = (BuyHouse) proxyFactory.getProxy(new BuyHouseImpl());
        proxy.buyHouse("张三");
    }
}
