package com.gihanz.controllers;

import com.gihanz.documents.Order;
import com.gihanz.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/save")
    public Order save(@RequestBody Order o){
        return   orderService.saveOrder(o);
    }
}
