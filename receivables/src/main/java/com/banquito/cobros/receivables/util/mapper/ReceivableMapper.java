package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.cobros.receivables.dto.ReceivableDTO;
import com.banquito.cobros.receivables.model.Receivable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceivableMapper {
    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "account.id", target = "accountId")
    ReceivableDTO toDTO(Receivable receivable);

    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "accountId", target = "account.id")
    Receivable toPersistence(ReceivableDTO dto);
}
