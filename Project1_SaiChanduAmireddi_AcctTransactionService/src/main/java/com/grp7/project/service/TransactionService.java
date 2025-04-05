package com.grp7.project.service;

import com.grp7.project.model.Transaction;
import com.grp7.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction txn) {
        return transactionRepository.save(txn);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getByOrderId(String orderId) {
        return transactionRepository.findByOrderId(orderId);
    }
}