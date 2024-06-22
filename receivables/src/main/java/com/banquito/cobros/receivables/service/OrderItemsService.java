package com.banquito.cobros.receivables.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.cobros.receivables.model.OrderItems;
import com.banquito.cobros.receivables.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Transactional
    public OrderItems createOrderItem(OrderItems orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Transactional(readOnly = true)
    public List<OrderItems> getOrderItemsByOrderId(Long orderId) {
        return orderItemsRepository.findByOrderId(orderId);
    }

    @Transactional(readOnly = true)
    public OrderItems getOrderItemById(Long id) {
        return orderItemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id));
    }

    @Transactional
    public void updateOrderItemStatus(Long id, String status) {
        OrderItems orderItems = getOrderItemById(id);
        orderItems.setStatus(status);
        orderItemsRepository.save(orderItems);
    }
}
