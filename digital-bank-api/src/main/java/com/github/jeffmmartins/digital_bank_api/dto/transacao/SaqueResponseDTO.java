package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para retornar o resultado de uma operação de saque
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaqueResponseDTO {
    
    private Long contaId;
    private BigDecimal valorSacado;
    private BigDecimal saldoAtual;
    private LocalDateTime dataTransacao;
    private String mensagem;
}