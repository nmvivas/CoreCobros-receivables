package com.banquito.cobros.receivables.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import com.banquito.cobros.receivables.dto.OrderDTO;
import com.banquito.cobros.receivables.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(source = "receivables.id", target = "receivableId")
    OrderDTO toDTO(Order order);

    @Mapping(source = "receivableId", target = "receivables.id")
    Order toPersistence(OrderDTO dto);
}
