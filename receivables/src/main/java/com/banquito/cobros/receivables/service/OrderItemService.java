package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.dto.OrderItemInfoDTO;
import com.banquito.cobros.receivables.util.mapper.OrderItemMapper;
import com.banquito.cobros.receivables.model.OrderItem;
import com.banquito.cobros.receivables.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Transactional(readOnly = true)
    public List<OrderItemDTO> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId).stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDTO getOrderItemById(Long id) {
        return orderItemMapper.toDTO(orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id)));
    }

    @Transactional
    public void updateOrderItemStatus(Long id, String status) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id));
        orderItem.setStatus(status);
        orderItemRepository.save(orderItem);
    }

    @Transactional(readOnly = true)
    public List<OrderItemInfoDTO> getOrderItemInfoByCounterpartAndCompanyId(String counterpart, Long companyId) {
        return orderItemRepository.findByCounterpartAndOrderReceivablesCompanyIdAndStatus(counterpart, companyId, "PEN")
                .stream()
                .map(orderItemMapper::toInfoDTO)
                .collect(Collectors.toList());
    }
}
