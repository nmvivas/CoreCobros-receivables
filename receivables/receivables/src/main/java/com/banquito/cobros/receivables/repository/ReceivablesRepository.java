package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.receivables.model.Receivables;

public interface ReceivablesRepository extends JpaRepository<Receivables, Long> {

}
