package com.github.jeffmmartins.digital_bank_api.repository;

import com.github.jeffmmartins.digital_bank_api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de persistência de Transações
 */
@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    
    /**
     * Busca todas as transações de uma conta específica
     * 
     * @param contaId ID da conta
     * @return Lista de transações da conta
     */
    List<Transacao> findByContaId(Long contaId);
}