package com.grp7.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "market_orders")
public class MarketOrder {
    @Id
    private String id;

    private String orderId;
    private String tickerSymbol;
    private int quantity;
    private String orderType;
    private double orderAmt;
    private String username;

    private String executionStatus;
    private LocalDateTime timestamp;
}