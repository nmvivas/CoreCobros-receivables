package com.cobros.core.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobros.core.receivables.model.PaymentRecord;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long>{

}
