package com.github.jeffmmartins.digital_bank_api.dto.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal; // Importação corrigida

@Getter
@Setter // Adicionado Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequestDTO {

    private String numeroDaConta;
    private String numeroDaAgencia;

    // CORREÇÃO: Usando BigDecimal
    private BigDecimal saldoDaConta;

    // Adicionado ID do cliente para saber a quem a conta pertence
    private Long clienteId;
}