package com.fendou.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: cjx
 * @Date: 2020-10-22 16:28
 * @Description;
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object o;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("进入之前");
        Object invoke = method.invoke(o, args);
        System.err.println("进入之后");
        return invoke;
    }
}
