package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.AccountDTO;
import com.banquito.cobros.receivables.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<AccountDTO>> getAccountsByCompanyId(@PathVariable Long companyId) {
        List<AccountDTO> accounts = accountService.getAccountsByCompanyId(companyId);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}
