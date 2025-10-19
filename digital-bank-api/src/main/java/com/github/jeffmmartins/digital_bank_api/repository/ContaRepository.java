package com.github.jeffmmartins.digital_bank_api.repository;

import com.github.jeffmmartins.digital_bank_api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByClienteId(Long clienteId);
}
