package com.banquito.cobros.receivables.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CompanyDTO {
    private Long id;
    private String ruc;
    private String companyName;
    private String legalRepresentative;
    private Boolean sriAuthorization;
    private Boolean contractAcceptance;
    private String clientEmail;
}
