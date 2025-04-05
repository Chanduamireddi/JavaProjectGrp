package com.grp7.project.dto;

import lombok.Data;

@Data
public class FeeSummaryDTO {
    private String orderId;
    private double feeAmount;
}