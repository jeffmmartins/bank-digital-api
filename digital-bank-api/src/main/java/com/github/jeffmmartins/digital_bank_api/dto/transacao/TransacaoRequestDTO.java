package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoRequestDTO {

    private Long id;
    private Double valorDaTransacao;
    private TipoTransacao tipoTransacao;
}
