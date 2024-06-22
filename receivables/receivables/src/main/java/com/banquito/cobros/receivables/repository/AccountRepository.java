package com.banquito.cobros.receivables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.cobros.receivables.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
