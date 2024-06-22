package com.banquito.cobros.receivables.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.cobros.receivables.model.PaymentRecord;
import com.banquito.cobros.receivables.repository.PaymentRecordRepository;

@Service
public class PaymentRecordService {

    private final PaymentRecordRepository paymentRecordRepository;

    public PaymentRecordService(PaymentRecordRepository paymentRecordRepository) {
        this.paymentRecordRepository = paymentRecordRepository;
    }

    @Transactional
    public PaymentRecord createPaymentRecord(PaymentRecord paymentRecord) {
        return paymentRecordRepository.save(paymentRecord);
    }

    @Transactional(readOnly = true)
    public List<PaymentRecord> getPaymentRecordsByOrderItemsId(Long orderItemsId) {
        return paymentRecordRepository.findByOrderItemsId(orderItemsId);
    }

    @Transactional(readOnly = true)
    public PaymentRecord getPaymentRecordById(Long id) {
        return paymentRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el registro de pago con id: " + id));
    }
}
