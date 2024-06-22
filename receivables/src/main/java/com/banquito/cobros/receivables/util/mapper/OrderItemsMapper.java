package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.OrderItemsDTO;
import com.banquito.cobros.receivables.model.OrderItems;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemsMapper {

    OrderItemsDTO toDTO(OrderItems orderItems);

    OrderItems toPersistence(OrderItemsDTO dto);
}
