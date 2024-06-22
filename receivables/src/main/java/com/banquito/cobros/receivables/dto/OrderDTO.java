package com.banquito.cobros.receivables.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderDTO {

    private Long id;
    private Integer receivableId;
    private LocalDate startDate;
    private LocalDate dueDate;
    private BigDecimal totalAmount;
    private String records;
    private String description;
    private String status;
}
