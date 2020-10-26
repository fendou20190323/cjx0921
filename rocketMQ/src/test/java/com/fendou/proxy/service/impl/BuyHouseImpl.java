package com.fendou.proxy.service.impl;

import com.fendou.proxy.service.BuyHouse;

public class BuyHouseImpl implements BuyHouse {

    @Override
    public void buyHouse(String name) {
        System.err.println(new StringBuilder(name).append("买房子").toString());
    }
}
