package com.fendou.mq;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: cjx
 * @Date: 2020-10-21 14:42
 * @Description;
 */
public class ThreadLocalTest {

    private ThreadLocal<Book> localBook = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread("t" + i) {
                @Override
                public void run() {
                    ThreadLocalTest localTest = new ThreadLocalTest();
                    localTest.test();
                }
            };
            t.start();
        }

        System.out.println();

    }

    public void test() {
        Book book = new Book();
        localBook.set(book);
        if (1 == 1) {

        }
    }

    @Test
    public void test2() {
        a:
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break a;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        Book b = new Book();
        Book a = b;
        System.err.println("主+set前：" + (b == a));
        setBook(b, a);
        System.err.println("主+set后：" + (b == a));

    }

    private void setBook(Book b, Book a) {
        b = new Book();
        System.err.println("次：" + (b == a));
    }

    @Test
    public void test4() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", 1);
        System.err.println();
    }

    @Test
    public void test5() {
        String a="sdfskfslfsfsjsifcxk";
        int b = a.hashCode();
        int c=b>>16;
        System.err.println("b="+b);
        System.err.println("c="+c);
        System.err.println("b:"+Integer.toBinaryString(b));
        System.err.println("c:"+Integer.toBinaryString(c));
        System.out.println(b ^ c);
    }
    @Test
    public void test6(){
        String a="10100101011101001010100000100";
        System.err.println(a.length());
    }

    @Test
    public void test7(){
        Set<Integer> a=new HashSet<>();
        for (int i = 0; i < 100; i++) {
            a.add(10&i);
        }

        System.err.println(a);
    }
    @Test
    public void test8(){
        for (int i = 0; i < 50; i++) {
            if ((i|4)==5){
                System.err.println(i);
            }
        }
    }
}
