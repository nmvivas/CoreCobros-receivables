package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.model.Receivables;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceivablesMapper {
    ReceivablesDTO toDTO(Receivables receivables);

    Receivables toPersistence(ReceivablesDTO dto);
}
