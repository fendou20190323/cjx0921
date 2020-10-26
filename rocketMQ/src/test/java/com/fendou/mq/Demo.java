package com.fendou.mq;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: cjx
 * @Date: 2020-10-20 15:02
 * @Description;
 */
public class Demo {

    public void getDeclareMeth(Class clazz){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
//            method.setAccessible(true);
            System.err.println(method.getName());
        }
    }
    public void getMeth(Class clazz){
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.err.println(method.getName());
        }
    }

    public void getFields(Class clazz) throws IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.err.println(field.get(new Book()));
        }
    }
    public void getField(Class clazz){
        try {

            Field field = clazz.getDeclaredField("price");
            field.setAccessible(true);
            Object o = field.get(new Book());
//            String name = field.getName();
            System.err.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getConstructors(Class clazz){
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class type : parameterTypes) {
                System.out.println(type.isAssignableFrom(type));
            }
        }
    }
    @Test
    public void test1(){
        try {
            Book book = new Book();
//        getMeth(Book.class);
//            getFields(book.getClass());
//        getField(book.getClass());
            getConstructors(book.getClass());
//        System.err.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
