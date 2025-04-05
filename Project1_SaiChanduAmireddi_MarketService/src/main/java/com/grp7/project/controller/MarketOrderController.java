package com.grp7.project.controller;

import com.grp7.project.model.MarketOrder;
import com.grp7.project.service.MarketOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/market")
public class MarketOrderController {

    @Autowired
    private MarketOrderService service;

    // POST: Create and save new Market Order
    @PostMapping("/place")
    @ResponseBody
    public String placeOrder(@RequestBody MarketOrder order) {
        order.setTimestamp(LocalDateTime.now());
        order.setExecutionStatus("RECEIVED");
        service.saveOrder(order);
        return "Market Order Placed Successfully.";
    }

    // GET: Fetch all market orders (JSON)
    @GetMapping("/orders")
    @ResponseBody
    public List<MarketOrder> getAllOrders() {
        return service.getAllOrders();
    }

    // GET: Fetch a single order by orderId (JSON)
    @GetMapping("/status/{orderId}")
    @ResponseBody
    public MarketOrder getByOrderId(@PathVariable String orderId) {
        return service.getByOrderId(orderId);
    }

    // ➤ GET: UI view for Market Orders (HTML using Thymeleaf)
    @GetMapping("/view")
    public String viewOrders(Model model) {
        model.addAttribute("orders", service.getAllOrders());
        return "marketOrders";
    }
}