package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByReceivableId(Long receivableId);

    Order findTopByOrderByIdDesc();
}
