package com.grp7.project.service;

import com.grp7.project.model.MarketOrder;
import com.grp7.project.repository.MarketOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketOrderService {

    @Autowired
    private MarketOrderRepository repository;

    public MarketOrder saveOrder(MarketOrder order) {
        return repository.save(order);
    }

    public MarketOrder getByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    public List<MarketOrder> getAllOrders() {
        return repository.findAll();
    }
}