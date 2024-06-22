package com.banquito.cobros.receivables.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.cobros.receivables.dto.PaymentRecordDTO;
import com.banquito.cobros.receivables.service.PaymentRecordService;
import com.banquito.cobros.receivables.util.mapper.PaymentRecordMapper;

@RestController
@RequestMapping("/payment-records")
public class PaymentRecordController {

    private final PaymentRecordService paymentRecordService;
    private final PaymentRecordMapper paymentRecordMapper;

    public PaymentRecordController(PaymentRecordService paymentRecordService, PaymentRecordMapper paymentRecordMapper) {
        this.paymentRecordService = paymentRecordService;
        this.paymentRecordMapper = paymentRecordMapper;
    }

    @PostMapping
    public ResponseEntity<PaymentRecordDTO> createPaymentRecord(@RequestBody PaymentRecordDTO paymentRecordDTO) {
        try {
            PaymentRecordDTO createdPaymentRecord = paymentRecordMapper
                    .toDTO(paymentRecordService
                            .createPaymentRecord(paymentRecordMapper.toPersistence(paymentRecordDTO)));
            return ResponseEntity.ok(createdPaymentRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/order-items/{orderItemsId}")
    public ResponseEntity<List<PaymentRecordDTO>> getPaymentRecordsByOrderItemsId(@PathVariable Long orderItemsId) {
        List<PaymentRecordDTO> paymentRecords = paymentRecordService.getPaymentRecordsByOrderItemsId(orderItemsId)
                .stream()
                .map(paymentRecordMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(paymentRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentRecordDTO> getPaymentRecordById(@PathVariable Long id) {
        try {
            PaymentRecordDTO paymentRecord = paymentRecordMapper.toDTO(paymentRecordService.getPaymentRecordById(id));
            return ResponseEntity.ok(paymentRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
