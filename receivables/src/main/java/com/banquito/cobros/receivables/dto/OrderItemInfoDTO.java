package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class OrderItemInfoDTO {
    private Long orderItemId;
    private String debtorName;
    private String counterpart;
    private String companyName;
    private String identification;
    private LocalDate dueDate;
}
