package com.zqy.lucky.service.impl;

import com.zqy.lucky.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String test1(String a) {
        return a+123;
    }
}
