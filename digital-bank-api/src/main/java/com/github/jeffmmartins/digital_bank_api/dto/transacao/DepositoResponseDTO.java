package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositoResponseDTO {

    private Long contaId;
    private BigDecimal valorDepositado;
    private BigDecimal saldoAtual;
    private LocalDateTime dataTransacao;
    private String mensagem;
}

