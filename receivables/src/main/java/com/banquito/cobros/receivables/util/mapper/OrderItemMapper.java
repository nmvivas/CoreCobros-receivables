package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.model.OrderItem;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);

    OrderItem toPersistence(OrderItemDTO dto);
}
