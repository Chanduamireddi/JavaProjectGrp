package com.grp7.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fees")
public class Fee {
    @Id
    private String feeId;
    private String orderId;
    private String username;
    private double orderAmount;
    private double feeAmount;
}