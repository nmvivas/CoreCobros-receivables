package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.Receivables;
import java.util.List;

public interface ReceivablesRepository extends JpaRepository<Receivables, Long> {

    List<Receivables> findByCompanyId(Long companyId);

    Receivables findTopByOrderByIdDesc();
}
