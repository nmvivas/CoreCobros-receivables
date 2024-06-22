package com.banquito.cobros.receivables.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentRecordDTO {

    private Long id;
    private Long orderItemsId;
    private String paymentType;
    private BigDecimal owedPayment;
    private LocalDateTime paymentDate;
    private BigDecimal outstandingBalance;
    private String channel;
}
