package com.gihanz.services;

import com.gihanz.documents.NumberGeneration;
import com.gihanz.documents.Order;
import com.gihanz.repositories.NumberGenerationRepository;
import com.gihanz.repositories.OrderRepository;
import com.gihanz.utils.NumberGenerationKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private NumberGenService numberGenService;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(Order order){

        try {
            order.setOrderNo( numberGenService.getNextCode(NumberGenerationKeys.ORDER_UNIQUE_KEY));
            return orderRepository.save(order);
        }catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
}
