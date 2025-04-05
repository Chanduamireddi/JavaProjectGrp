package com.grp7.project.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MarketOrderDTO {
    private String orderId;
    private String tickerSymbol;
    private String orderType;
    private int quantity;
    private Double orderAmt;
    private String username;
    private LocalDateTime timestamp;
}
