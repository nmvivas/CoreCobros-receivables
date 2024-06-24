package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@Builder
public class OrderDTO {

    private Long id;
    private Long receivableId;
    private LocalDate startDate;
    private LocalDate dueDate;
    private BigDecimal totalAmount;
    private String records;
    private String description;
    private String status;
}
