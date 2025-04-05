package com.grp7.project.controller;

import com.grp7.project.dto.TransactionDTO;
import com.grp7.project.dto.FeeDTO;
import com.grp7.project.dto.MarketOrderDTO;
import com.grp7.project.model.Order;
import com.grp7.project.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    // Service URLs (use Eureka service names)
    private final String TXN_SERVICE_URL = "http://PROJECT1_SAICHANDUAMIREDDI_ACCTTRANSACTIONSERVICE/api/transactions/create";
    private final String FEE_SERVICE_URL = "http://PROJECT1_SAICHANDUAMIREDDI_FEESERVICE/api/fees/calculate";
    private final String MARKET_SERVICE_URL = "http://PROJECT1_SAICHANDUAMIREDDI_MARKETSERVICE/api/market/place";

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/order")
    public String orderForm(Model model) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setAttribute("manual"); // if attribute field is used
        model.addAttribute("order", order);
        return "orderForm";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@ModelAttribute Order order, RedirectAttributes redirectAttrs) {
        try {
            order.setOrderDate(LocalDateTime.now());
            orderService.saveOrder(order);

            // Send Transaction to AcctTransactionService
            TransactionDTO txn = new TransactionDTO();
            txn.setOrderId(order.getOrderId());
            txn.setType("DEBIT");
            txn.setAmount(order.getOrderAmt());
            txn.setStatus("RESERVED");
            txn.setUsername(order.getUsername());
            txn.setDescription("Reserved stock for order " + order.getOrderId());
            txn.setTimestamp(order.getOrderDate());

            restTemplate.postForObject(TXN_SERVICE_URL, txn, String.class);

            // Send Fee to FeeService
            FeeDTO feeDTO = new FeeDTO();
            feeDTO.setOrderId(order.getOrderId());
            feeDTO.setUsername(order.getUsername());
            feeDTO.setOrderAmount(order.getOrderAmt());

            restTemplate.postForObject(FEE_SERVICE_URL, feeDTO, String.class);

            // Send to MarketService
            MarketOrderDTO marketOrder = new MarketOrderDTO();
            marketOrder.setOrderId(order.getOrderId());
            marketOrder.setTickerSymbol(order.getTickerSymbol());
            marketOrder.setOrderAmt(order.getOrderAmt());
            marketOrder.setOrderType(order.getOrderType_BuyOrSell());
            marketOrder.setQuantity(order.getQuantity());
            marketOrder.setUsername(order.getUsername());
            marketOrder.setTimestamp(order.getOrderDate());

            restTemplate.postForObject(MARKET_SERVICE_URL, marketOrder, String.class);

            redirectAttrs.addFlashAttribute("success", "Order placed and processed successfully.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error processing order: " + e.getMessage());
        }

        return "redirect:/myOrders";
    }

    @GetMapping("/myOrders")
    public String viewMyOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "myOrders";
    }
}