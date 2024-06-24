package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cobros.receivables.model.Receivable;
import java.util.List;

public interface ReceivableRepository extends JpaRepository<Receivable, Long> {
    List<Receivable> findByCompanyId(Long companyId);

    Receivable findTopByOrderByIdDesc();
}
