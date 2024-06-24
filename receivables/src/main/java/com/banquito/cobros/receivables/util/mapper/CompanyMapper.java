package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.model.Company;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    CompanyDTO toDTO(Company company);

    Company toPersistence(CompanyDTO dto);
}
