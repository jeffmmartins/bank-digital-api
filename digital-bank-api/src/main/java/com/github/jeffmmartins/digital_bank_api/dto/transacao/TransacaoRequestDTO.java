package com.github.jeffmmartins.digital_bank_api.dto.transacao;

import com.github.jeffmmartins.digital_bank_api.model.Transacao;
import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequestDTO {

    private Long id;
    private Double valorDaTransacao;
    private TipoTransacao tipoDeTransacao;

}
