package com.fendou.proxy.factory;

import com.fendou.proxy.handler.MyInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @Author: cjx
 * @Date: 2020-10-22 16:17
 * @Description;
 */
public class ProxyFactory {


    public Object getProxy(Object o) {

        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(), new MyInvocationHandler(o));
    }
}
