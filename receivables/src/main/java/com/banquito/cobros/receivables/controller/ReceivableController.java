package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.ReceivableDTO;
import com.banquito.cobros.receivables.service.ReceivableService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping("/receivables")
public class ReceivableController {

    private final ReceivableService receivableService;

    public ReceivableController(ReceivableService receivableService) {
        this.receivableService = receivableService;
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ReceivableDTO>> getReceivablesByCompanyId(@PathVariable Long companyId) {
        List<ReceivableDTO> receivables = receivableService.getReceivablesByCompanyId(companyId);
        return ResponseEntity.ok(receivables);
    }

    @GetMapping
    public ResponseEntity<List<ReceivableDTO>> getAllReceivables() {
        List<ReceivableDTO> receivables = receivableService.getAllReceivables();
        return ResponseEntity.ok(receivables);
    }

    @PostMapping
    public ResponseEntity<ReceivableDTO> createReceivable(@RequestBody ReceivableDTO receivableDTO) {
        ReceivableDTO createdReceivable = receivableService.createReceivable(receivableDTO);
        return ResponseEntity.ok(createdReceivable);
    }

    @GetMapping("/last")
    public ResponseEntity<ReceivableDTO> getLastInsertedReceivable() {
        ReceivableDTO receivable = receivableService.getLastInsertedReceivable();
        return ResponseEntity.ok(receivable);
    }
}
