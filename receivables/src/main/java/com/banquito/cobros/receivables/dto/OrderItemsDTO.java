package com.banquito.cobros.receivables.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderItemsDTO {

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
