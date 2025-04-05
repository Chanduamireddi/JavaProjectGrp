package com.grp7.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grp7.project.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}