package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@Builder
public class PaymentRecordDTO {

    private Long id;
    private Long orderItemId;
    private String paymentType;
    private BigDecimal owedPayment;
    private LocalDateTime paymentDate;
    private BigDecimal outstandingBalance;
    private String channel;
}
