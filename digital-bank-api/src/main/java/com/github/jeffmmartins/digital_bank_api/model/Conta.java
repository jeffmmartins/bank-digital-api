package com.github.jeffmmartins.digital_bank_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroDaConta;
    private Integer numeroDaAgencia;
    private Double saldoDaConta;

    public Conta(){}

    public Conta(Integer numeroDaConta, Integer numeroDaAgencia, Double saldoDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.numeroDaAgencia = numeroDaAgencia;
        this.saldoDaConta = saldoDaConta;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public Integer getNumeroDaAgencia() {
        return numeroDaAgencia;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setNumeroDaConta(Integer numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public void setNumeroDaAgencia(Integer numeroDaAgencia) {
        this.numeroDaAgencia = numeroDaAgencia;
    }

    public void setSaldoDaConta(Double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }
}
