package com.github.jeffmmartins.digital_bank_api.repository;

import com.github.jeffmmartins.digital_bank_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
