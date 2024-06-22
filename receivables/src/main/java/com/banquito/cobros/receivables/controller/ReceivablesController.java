package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.service.ReceivablesService;
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

    @GetMapping
    public List<ReceivablesDTO> getAllReceivables() {
        return receivablesService.getAllReceivables();
    }
}
