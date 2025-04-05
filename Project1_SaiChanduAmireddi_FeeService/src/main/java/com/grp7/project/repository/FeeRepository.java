package com.grp7.project.repository;

import com.grp7.project.model.Fee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeeRepository extends MongoRepository<Fee, String> {
    Fee findByOrderId(String orderId);
}