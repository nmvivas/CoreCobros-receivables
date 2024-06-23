package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.PaymentRecordDTO;
import com.banquito.cobros.receivables.model.PaymentRecord;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentRecordMapper {

    @Mapping(source = "orderItem.id", target = "orderItemId")
    PaymentRecordDTO toDTO(PaymentRecord paymentRecord);

    @Mapping(source = "orderItemId", target = "orderItem.id")
    PaymentRecord toPersistence(PaymentRecordDTO paymentRecordDTO);
}
