package com.gihanz.repositories;

import com.gihanz.documents.Item;
import com.gihanz.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends MongoRepository<Item, String> {
    void deleteByItemCode(String ItemCode);
    Item findByItemCode(String itemCode);

}
