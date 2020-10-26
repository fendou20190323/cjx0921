package com.fendou.mq;

import java.util.Set;

/**
 * @Author: cjx
 * @Date: 2020-10-20 15:04
 * @Description;
 */
public class Book {
    private String name;

    public String id;

    public static String desc;

    private String price="ab";

    public Book() {
    }

    public Book(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public  void setId2(String id){
        this.id=id;
    }
    private   void setId1(String id){
        this.id=id;
    }
    public static String getDesc(){
        return desc;
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "name='" + name + '\'' +
//                ", id='" + id + '\'' +
//                ", price='" + price + '\'' +
//                '}';
//    }
}
