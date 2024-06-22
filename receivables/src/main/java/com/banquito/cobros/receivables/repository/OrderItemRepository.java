package com.banquito.cobros.receivables.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
