package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountDTO {

    private Long id;
    private Long companyId;
    private String accountNumber;
    private String type;
    private String status;
}
