package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.AccountDTO;
import com.banquito.cobros.receivables.model.Account;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    @Mapping(source = "company.id", target = "companyId")
    AccountDTO toDTO(Account account);

    @Mapping(source = "companyId", target = "company.id")
    Account toPersistence(AccountDTO dto);
}
