
package com.grp7.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String orderId;
    private int quantity;
    private String tickerSymbol;
    private double orderAmt;
    private String addMoreAsRequired;
    private LocalDateTime orderDate;
    private String feeId;
    private String attribute;
    private String orderType_BuyOrSell;
    private String username;
}
