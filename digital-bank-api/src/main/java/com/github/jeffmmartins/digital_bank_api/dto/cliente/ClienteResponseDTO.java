package com.github.jeffmmartins.digital_bank_api.dto.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;

}
