package com.grp7.project.controller;

import com.grp7.project.model.Transaction;
import com.grp7.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create Transaction (used by OrderService)
    @PostMapping("/create")
    @ResponseBody
    public Transaction createTransaction(@RequestBody Transaction txn) {
        return transactionService.saveTransaction(txn);
    }

    // REST: Get all transactions
    @GetMapping
    @ResponseBody
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get transaction by orderId
    @GetMapping("/{orderId}")
    @ResponseBody
    public Transaction getByOrderId(@PathVariable String orderId) {
        return transactionService.getByOrderId(orderId);
    }

    // Thymeleaf page to show all transactions in browser
    @GetMapping("/view")
    public String viewTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactionsList";
    }
}