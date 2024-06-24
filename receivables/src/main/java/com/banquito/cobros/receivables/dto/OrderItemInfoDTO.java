package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class OrderItemInfoDTO {
    private Long orderItemId;
    private String companyName;
    private LocalDate dueDate;
    private String debtorName;
    private String identificationType;
    private String identification;
    private String debitAccount;
    private BigDecimal owedAmount;
    private String counterpart;
    private String status;
}
