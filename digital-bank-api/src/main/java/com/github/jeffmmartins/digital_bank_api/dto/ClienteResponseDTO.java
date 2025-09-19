package com.github.jeffmmartins.digital_bank_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    private Long id;
    private String nome;
    private String cpf;

}
