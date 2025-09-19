package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransacaoResponseDTO {

    private Long id;
    private Double valorDaTransacao;
    private TipoTransacao tipoDeTransacao;
    private LocalDateTime DataDaTransacao;
}
