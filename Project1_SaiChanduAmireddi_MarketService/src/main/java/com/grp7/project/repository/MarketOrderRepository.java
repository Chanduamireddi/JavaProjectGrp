package com.grp7.project.repository;

import com.grp7.project.model.MarketOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketOrderRepository extends MongoRepository<MarketOrder, String> {
    MarketOrder findByOrderId(String orderId);
}
