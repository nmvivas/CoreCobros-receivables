package com.cobros.core.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobros.core.receivables.model.Receivables;

public interface ReceivablesRepository extends JpaRepository<Receivables, Long>{

}
