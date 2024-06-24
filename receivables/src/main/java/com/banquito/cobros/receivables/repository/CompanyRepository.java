package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByCompanyNameContaining(String namePattern);

    Company findByClientCompany(String clientCompany);
}
