package com.cobros.core.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobros.core.receivables.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long>{



}
