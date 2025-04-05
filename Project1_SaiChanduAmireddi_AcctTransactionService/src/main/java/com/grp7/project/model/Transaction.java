package com.grp7.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String orderId;
    private String username;
    private Double amount;
    private String type;
    private String status;
    private String description;
    private LocalDateTime timestamp;
}
