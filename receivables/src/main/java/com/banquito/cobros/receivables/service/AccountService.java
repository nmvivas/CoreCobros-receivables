package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.AccountDTO;
import com.banquito.cobros.receivables.repository.AccountRepository;
import com.banquito.cobros.receivables.util.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional(readOnly = true)
    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("No existe la cuenta con id: " + id));
    }

    @Transactional(readOnly = true)
    public List<AccountDTO> getAccountsByCompanyId(Long companyId) {
        return accountRepository.findByCompanyId(companyId).stream()
                .map(accountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toDTO)
                .collect(Collectors.toList());
    }
}
