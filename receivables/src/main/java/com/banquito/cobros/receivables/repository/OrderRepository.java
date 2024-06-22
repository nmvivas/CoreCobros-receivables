package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
