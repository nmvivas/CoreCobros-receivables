package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.service.ReceivablesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
