package com.banquito.cobros.receivables.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banquito.cobros.receivables.model.OrderItem;
import com.banquito.cobros.receivables.repository.OrderItemRepository;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Transactional(readOnly = true)
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Transactional(readOnly = true)
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el item de orden con id: " + id));
    }

    @Transactional
    public void updateOrderItemStatus(Long id, String status) {
        OrderItem orderItem = getOrderItemById(id);
        orderItem.setStatus(status);
        orderItemRepository.save(orderItem);
    }
}
