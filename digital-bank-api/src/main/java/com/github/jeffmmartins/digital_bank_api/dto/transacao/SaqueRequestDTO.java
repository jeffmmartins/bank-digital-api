package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO para receber requisições de saque
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaqueRequestDTO {
    
    @NotNull(message = "O ID da conta é obrigatório")
    private Long contaId;
    
    @NotNull(message = "O valor do saque é obrigatório")
    @Positive(message = "O valor do saque deve ser maior que zero")
    private BigDecimal valor;
}