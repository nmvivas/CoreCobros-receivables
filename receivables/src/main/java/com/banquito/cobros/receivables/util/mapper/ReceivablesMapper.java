package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.model.Receivables;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceivablesMapper {
    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "account.id", target = "accountId")
    ReceivablesDTO toDTO(Receivables receivables);

    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "accountId", target = "account.id")
    Receivables toPersistence(ReceivablesDTO dto);
}