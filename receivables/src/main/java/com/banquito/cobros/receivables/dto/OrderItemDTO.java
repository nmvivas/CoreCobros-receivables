package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrderItemDTO {

    private Long id;
    private Long orderId;
    private String debtorName;
    private String identificationType;
    private String identification;
    private String debitAccount;
    private BigDecimal owedAmount;
    private String counterpart;
    private String status;
}
