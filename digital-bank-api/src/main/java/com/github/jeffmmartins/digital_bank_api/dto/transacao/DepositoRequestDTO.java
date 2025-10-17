package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO para receber requisições de depósito
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados para realizar um depósito")
public class DepositoRequestDTO {

    @NotNull(message = "O ID da conta é obrigatório")
    @Schema(description = "ID da conta para depósito", example = "1")
    private Long contaId;

    @NotNull(message = "O valor do depósito é obrigatório")
    @Positive(message = "O valor do depósito deve ser maior que zero")
    @Schema(description = "Valor a ser depositado", example = "100.00")
    private BigDecimal valor;
}