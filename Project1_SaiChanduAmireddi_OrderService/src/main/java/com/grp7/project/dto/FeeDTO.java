package com.grp7.project.dto;

import lombok.Data;

@Data
public class FeeDTO {
    private String orderId;
    private String username;
    private Double orderAmount;
}
