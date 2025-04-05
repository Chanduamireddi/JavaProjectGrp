package com.grp7.project.service;

import com.grp7.project.model.Fee;
import com.grp7.project.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeeService {

    @Autowired
    private FeeRepository repository;

    public Fee calculateFee(Fee input) {
        Fee fee = new Fee();
        fee.setFeeId(UUID.randomUUID().toString());
        fee.setOrderId(input.getOrderId());
        fee.setUsername(input.getUsername());
        fee.setOrderAmount(input.getOrderAmount());
        fee.setFeeAmount(input.getOrderAmount() * 0.01);
        return repository.save(fee);
    }

    public Fee getFeeByOrderId(String orderId) {
        return repository.findByOrderId(orderId);
    }

    public List<Fee> getAllFees() {
        return repository.findAll();
    }
}