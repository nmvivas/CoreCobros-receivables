package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);

    List<OrderItem> findByOrderReceivablesCompanyIdAndStatus(Long companyId,
            String status);
}
