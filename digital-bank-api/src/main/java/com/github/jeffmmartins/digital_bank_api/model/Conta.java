package com.github.jeffmmartins.digital_bank_api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal; // Importação corrigida
import java.util.ArrayList; // Importação adicionada
import java.util.List;

@Entity
@Table(name = "tb_conta")
@Getter
@Setter
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter(AccessLevel.NONE)
    private String numeroDaConta;

    @Setter(AccessLevel.NONE)
    private String numeroDaAgencia;

    // CORREÇÃO: Usando BigDecimal para dinheiro
    @Column(precision = 19, scale = 2) // Define a precisão no banco
    private BigDecimal saldoDaConta = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Cliente cliente;

    // CORREÇÃO: Inicializando a lista
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private List<Transacao> transacoes = new ArrayList<>();

    // Construtor principal
    public Conta(String numeroDaConta, String numeroDaAgencia, Cliente cliente) {
        this.numeroDaConta = numeroDaConta;
        this.numeroDaAgencia = numeroDaAgencia;
        this.cliente = cliente;
        this.saldoDaConta = BigDecimal.ZERO;
    }

    // Construtor para DataLoader
    public Conta(String numeroDaConta, String numeroDaAgencia, Cliente cliente, BigDecimal saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.numeroDaAgencia = numeroDaAgencia;
        this.cliente = cliente;
        this.saldoDaConta = saldoInicial != null ? saldoInicial : BigDecimal.ZERO;
    }
}
