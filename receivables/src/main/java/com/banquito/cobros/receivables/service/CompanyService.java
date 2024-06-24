package com.banquito.cobros.receivables.service;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.model.Company;
import com.banquito.cobros.receivables.repository.CompanyRepository;
import com.banquito.cobros.receivables.util.mapper.CompanyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CompanyDTO> getCompaniesByNamePattern(String namePattern) {
        return companyRepository.findByCompanyNameContaining(namePattern).stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CompanyDTO getCompanyByClientEmail(String clientCompany) {
        Company company = companyRepository.findByClientCompany(clientCompany);
        if (company == null) {
            throw new RuntimeException("No existe la compañía con el correo electrónico: " + clientCompany);
        }
        return companyMapper.toDTO(company);
    }

    @Transactional
    public CompanyDTO updateCompanyById(Long id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la compañía con id: " + id));
        company.setRuc(companyDTO.getRuc());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setLegalRepresentative(companyDTO.getLegalRepresentative());
        company.setSriAuthorization(companyDTO.getSriAuthorization());
        company.setContractAcceptance(companyDTO.getContractAcceptance());
        company.setClientCompany(companyDTO.getClientCompany());
        return companyMapper.toDTO(companyRepository.save(company));
    }
}
