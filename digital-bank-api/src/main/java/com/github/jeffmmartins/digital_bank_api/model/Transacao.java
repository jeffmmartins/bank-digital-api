package com.github.jeffmmartins.digital_bank_api.model;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;

import java.time.LocalDate;

public class Transacao {
    private Long id;
    private Double valorDaTransacao;
    private TipoTransacao tipoDeTransacao;
    private LocalDate dataDaTransacao;
}
