package com.cobros.core.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobros.core.receivables.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
