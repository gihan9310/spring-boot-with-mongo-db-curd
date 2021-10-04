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
@Transactional
public class OrderService {

    @Autowired
    private NumberGenerationRepository numberGenerationRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){

        try {

            NumberGeneration nextNumber = numberGenerationRepository.findBySearchKey(NumberGenerationKeys.ORDER_UNIQUE_KEY);
            order.setOrderNo(nextNumber.getPrefix()+nextNumber.getNextNumber());
            nextNumber.setNextNumber(nextNumber.getNextNumber()+1);
            numberGenerationRepository.save(nextNumber);
            return orderRepository.save(order);

        }catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
}
