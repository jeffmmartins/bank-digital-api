package com.github.jeffmmartins.digital_bank_api.dto.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaRequestDTO {

    private String numeroDaConta;
    private String numeroDaAgencia;
    private Double saldoDaConta;


}
