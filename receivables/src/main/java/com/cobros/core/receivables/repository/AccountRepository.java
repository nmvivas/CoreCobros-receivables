package com.cobros.core.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobros.core.receivables.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
