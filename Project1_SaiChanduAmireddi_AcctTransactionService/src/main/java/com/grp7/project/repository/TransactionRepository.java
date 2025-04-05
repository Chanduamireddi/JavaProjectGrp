package com.grp7.project.repository;

import com.grp7.project.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    Transaction findByOrderId(String orderId);
}