package com.github.jeffmmartins.digital_bank_api.model;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;

import java.time.LocalDate;

public class Transacao {
    private Long id;
    private Double valorDaTransacao;
    private TipoTransacao tipoDeTransacao;
    private LocalDate dataDaTransacao;

    public Transacao(){

    }

    public Transacao(Double valorDaTransacao, TipoTransacao tipoDeTransacao, LocalDate dataDaTransacao) {
        this.valorDaTransacao = valorDaTransacao;
        this.tipoDeTransacao = tipoDeTransacao;
        this.dataDaTransacao = dataDaTransacao;
    }

    public Long getId() {
        return id;
    }


    public Double getValorDaTransacao() {
        return valorDaTransacao;
    }

    public void setValorDaTransacao(Double valorDaTransacao) {
        this.valorDaTransacao = valorDaTransacao;
    }

    public TipoTransacao getTipoDeTransacao() {
        return tipoDeTransacao;
    }

    public void setTipoDeTransacao(TipoTransacao tipoDeTransacao) {
        this.tipoDeTransacao = tipoDeTransacao;
    }

    public LocalDate getDataDaTransacao() {
        return dataDaTransacao;
    }

    public void setDataDaTransacao(LocalDate dataDaTransacao) {
        this.dataDaTransacao = dataDaTransacao;
    }
}
