package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;

@Value
@Builder
public class ReceivablesDTO {

    private Long id;
    private Long companyId;
    private Long accountId;
    private String type;
    private String name;
    private LocalDateTime date;
}