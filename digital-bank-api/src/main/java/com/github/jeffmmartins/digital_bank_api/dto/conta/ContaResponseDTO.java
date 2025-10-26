package com.github.jeffmmartins.digital_bank_api.dto.conta;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal; // Importação corrigida

@Getter
@Setter
public class ContaResponseDTO {

    private Long id;
    private String numeroDaConta; // Adicionado
    private String numeroDaAgencia; // Adicionado
    private Long clienteId; // Adicionado
    private BigDecimal saldoDaConta; // CORREÇÃO: Usando BigDecimal

}