package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.OrderDTO;
import com.banquito.cobros.receivables.model.Order;
import com.banquito.cobros.receivables.repository.OrderRepository;
import com.banquito.cobros.receivables.util.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByReceivablesId(Long receivablesId) {
        return orderRepository.findByReceivablesId(receivablesId).stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        if (orderDTO.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha de inicio debe ser igual o mayor a la fecha actual.");
        }
        if (orderDTO.getDueDate().isBefore(orderDTO.getStartDate())) {
            throw new RuntimeException("La fecha de vencimiento debe ser mayor a la fecha de inicio.");
        }
        return orderMapper.toDTO(orderRepository.save(orderMapper.toPersistence(orderDTO)));
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("No existe la orden con id: " + id));
    }

    @Transactional
    public void updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la orden con id: " + id));
        order.setStatus(status);
        orderRepository.save(order);
    }
}
