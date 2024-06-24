package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.service.ReceivablesService;

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
public class ReceivablesController {

    private final ReceivablesService receivablesService;

    public ReceivablesController(ReceivablesService receivablesService) {
        this.receivablesService = receivablesService;
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ReceivablesDTO>> getReceivablesByCompanyId(@PathVariable Long companyId) {
        List<ReceivablesDTO> receivables = receivablesService.getReceivablesByCompanyId(companyId);
        return ResponseEntity.ok(receivables);
    }

    @GetMapping
    public ResponseEntity<List<ReceivablesDTO>> getAllReceivables() {
        List<ReceivablesDTO> receivables = receivablesService.getAllReceivables();
        return ResponseEntity.ok(receivables);
    }

    @PostMapping
    public ResponseEntity<ReceivablesDTO> createReceivables(@RequestBody ReceivablesDTO receivablesDTO) {
        ReceivablesDTO createdReceivables = receivablesService.createReceivables(receivablesDTO);
        return ResponseEntity.ok(createdReceivables);
    }

    @GetMapping("/last")
    public ResponseEntity<ReceivablesDTO> getLastInsertedReceivables() {
        ReceivablesDTO receivables = receivablesService.getLastInsertedReceivables();
        return ResponseEntity.ok(receivables);
    }
}
