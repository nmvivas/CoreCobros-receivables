package com.banquito.cobros.receivables.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.cobros.receivables.model.Order;
import com.banquito.cobros.receivables.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(Order order) {
        if (order.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha de inicio debe ser igual o mayor a la fecha actual.");
        }
        if (order.getDueDate().isBefore(order.getStartDate())) {
            throw new RuntimeException("La fecha de vencimiento debe ser mayor a la fecha de inicio.");
        }
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la orden con id: " + id));
    }

    @Transactional
    public void updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        orderRepository.save(order);
    }
}
