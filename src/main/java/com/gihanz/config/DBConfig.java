package com.gihanz.config;

import com.gihanz.documents.NumberGeneration;
import com.gihanz.repositories.NumberGenerationRepository;
import com.gihanz.utils.NumberGenerationKeys;
import org.springframework.stereotype.Component;

@Component
public class DBConfig {


    DBConfig(NumberGenerationRepository numberGenerationRepository){

        if(numberGenerationRepository.findBySearchKey(NumberGenerationKeys.ORDER_UNIQUE_KEY)==null){
            NumberGeneration orderNumber = new NumberGeneration();
            orderNumber.setNextNumber(1l);
            orderNumber.setPrefix("ORDER-00");
            orderNumber.setSearchKey(NumberGenerationKeys.ORDER_UNIQUE_KEY);
            orderNumber.setSuffix("ORDER-00");
            numberGenerationRepository.save(orderNumber);
        }

    }
}
