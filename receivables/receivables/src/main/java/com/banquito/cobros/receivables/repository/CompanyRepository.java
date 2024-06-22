package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.receivables.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
