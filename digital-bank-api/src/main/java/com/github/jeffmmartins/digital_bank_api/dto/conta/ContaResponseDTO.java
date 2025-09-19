package com.github.jeffmmartins.digital_bank_api.dto.conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaResponseDTO {

    private Long id;
    private String numeroDaConta;
    private String numeroDaAgencia;

}
