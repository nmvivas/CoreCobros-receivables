package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.OrderItemDTO;
import com.banquito.cobros.receivables.dto.OrderItemInfoDTO;
import com.banquito.cobros.receivables.model.OrderItem;
import com.banquito.cobros.receivables.repository.CompanyRepository;
import com.banquito.cobros.receivables.repository.OrderItemRepository;
import com.banquito.cobros.receivables.util.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final CompanyRepository companyRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper,
            CompanyRepository companyRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public OrderItemDTO getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id));
        return orderItemMapper.toDTO(orderItem);
    }

    @Transactional(readOnly = true)
    public List<OrderItemDTO> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId).stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderItemDTO> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Transactional
    public void updateOrderItemStatus(Long id, String status) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id));
        orderItem.setStatus(status);
        orderItemRepository.save(orderItem);
    }

    @Transactional(readOnly = true)
    public List<OrderItemInfoDTO> getOrderItemInfoByCompanyId(Long companyId) {
        return orderItemRepository.findByOrderReceivableCompanyIdAndStatus(companyId, "PEN")
                .stream()
                .map(orderItemMapper::toInfoDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderItemInfoDTO> getOrderItemInfoByCounterpartAndCompanyId(String counterpart, Long companyId) {
        boolean companyExists = companyRepository.existsById(companyId);
        boolean counterpartExists = orderItemRepository
                .findByCounterpartAndOrderReceivableCompanyId(counterpart, companyId).size() > 0;

        if (!companyExists || !counterpartExists) {
            throw new RuntimeException("La contrapartida o la compañía no existen");
        }

        return orderItemRepository.findByCounterpartAndOrderReceivableCompanyId(counterpart, companyId).stream()
                .map(orderItemMapper::toInfoDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderItemDTO> getOrderItemsByReceivableType(String type) {
        return orderItemRepository.findByOrderReceivableType(type).stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
