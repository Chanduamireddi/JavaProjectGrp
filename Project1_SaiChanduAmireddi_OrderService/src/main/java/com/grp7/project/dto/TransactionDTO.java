package com.grp7.project.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private String orderId;
    private String type;
    private Double amount;
    private String status;
    private String username;
    private String description;
    private LocalDateTime timestamp;
}