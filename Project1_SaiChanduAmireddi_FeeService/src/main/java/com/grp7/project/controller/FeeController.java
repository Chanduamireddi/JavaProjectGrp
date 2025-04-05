package com.grp7.project.controller;

import com.grp7.project.model.Fee;
import com.grp7.project.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/calculate")
    public Fee calculate(@RequestBody Fee fee) {
        return feeService.calculateFee(fee);
    }

    @GetMapping("/{orderId}")
    public Fee getFeeByOrderId(@PathVariable String orderId) {
        return feeService.getFeeByOrderId(orderId);
    }

    @GetMapping
    public List<Fee> getAll() {
        return feeService.getAllFees();
    }
}