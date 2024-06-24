package com.banquito.cobros.receivables.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.PaymentRecord;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long> {

    List<PaymentRecord> findByOrderItemId(Long orderItemId);
}
