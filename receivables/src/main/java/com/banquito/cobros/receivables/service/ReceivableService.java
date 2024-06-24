package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.ReceivableDTO;
import com.banquito.cobros.receivables.model.Receivable;
import com.banquito.cobros.receivables.repository.ReceivableRepository;
import com.banquito.cobros.receivables.util.mapper.ReceivableMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceivableService {

    private final ReceivableRepository receivableRepository;
    private final ReceivableMapper receivableMapper;

    public ReceivableService(ReceivableRepository receivableRepository, ReceivableMapper receivableMapper) {
        this.receivableRepository = receivableRepository;
        this.receivableMapper = receivableMapper;
    }

    @Transactional(readOnly = true)
    public ReceivableDTO getReceivablesById(Long id) {
        Receivable receivables = receivableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el recibo con id: " + id));
        return receivableMapper.toDTO(receivables);
    }

    @Transactional(readOnly = true)
    public List<ReceivableDTO> getReceivablesByCompanyId(Long companyId) {
        return receivableRepository.findByCompanyId(companyId).stream()
                .map(receivableMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ReceivableDTO> getAllReceivables() {
        return receivableRepository.findAll().stream()
                .map(receivableMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ReceivableDTO createReceivable(ReceivableDTO receivableDTO) {
        if (receivableDTO.getId() != null && receivableRepository.existsById(receivableDTO.getId())) {
            throw new RuntimeException("El ID " + receivableDTO.getId() + " ya existe.");
        }
        Receivable receivable = receivableMapper.toPersistence(receivableDTO);
        return receivableMapper.toDTO(receivableRepository.save(receivable));
    }

    @Transactional(readOnly = true)
    public ReceivableDTO getLastInsertedReceivable() {
        Receivable receivable = receivableRepository.findTopByOrderByIdDesc();
        return receivableMapper.toDTO(receivable);
    }
}
