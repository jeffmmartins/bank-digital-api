package com.github.jeffmmartins.digital_bank_api.repository;

import com.github.jeffmmartins.digital_bank_api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
