package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.ReceivablesDTO;
import com.banquito.cobros.receivables.repository.ReceivablesRepository;
import com.banquito.cobros.receivables.util.mapper.ReceivablesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceivablesService {

    private final ReceivablesRepository receivablesRepository;
    private final ReceivablesMapper receivablesMapper;

    public ReceivablesService(ReceivablesRepository receivablesRepository, ReceivablesMapper receivablesMapper) {
        this.receivablesRepository = receivablesRepository;
        this.receivablesMapper = receivablesMapper;
    }

    @Transactional(readOnly = true)
    public List<ReceivablesDTO> getReceivablesByCompanyId(Long companyId) {
        return receivablesRepository.findByCompanyId(companyId).stream()
                .map(receivablesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ReceivablesDTO> getAllReceivables() {
        return receivablesRepository.findAll().stream()
                .map(receivablesMapper::toDTO)
                .collect(Collectors.toList());
    }
}
