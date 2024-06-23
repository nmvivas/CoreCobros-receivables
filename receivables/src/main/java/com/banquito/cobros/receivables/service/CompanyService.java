package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.model.Company;
import com.banquito.cobros.receivables.repository.CompanyRepository;
import com.banquito.cobros.receivables.util.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CompanyDTO> getCompaniesByNamePattern(String namePattern) {
        return companyRepository.findByCompanyNameContaining(namePattern).stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CompanyDTO getCompanyByClientEmail(String clientEmail) {
        Company company = companyRepository.findByClientEmail(clientEmail);
        if (company == null) {
            throw new RuntimeException("No existe la compañía con el correo electrónico: " + clientEmail);
        }
        return companyMapper.toDTO(company);
    }
}
