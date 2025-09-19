package com.github.jeffmmartins.digital_bank_api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Double saldoDaConta = 0.0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private List<Transacao> transacoes;

    public Conta(String numeroDaConta, String numeroDaAgencia, Cliente cliente) {
        this.numeroDaConta = numeroDaConta;
        this.numeroDaAgencia = numeroDaAgencia;
        this.cliente = cliente;
    }
}
