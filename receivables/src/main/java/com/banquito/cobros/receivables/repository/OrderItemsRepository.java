package com.banquito.cobros.receivables.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findByOrderId(Long orderId);
}
