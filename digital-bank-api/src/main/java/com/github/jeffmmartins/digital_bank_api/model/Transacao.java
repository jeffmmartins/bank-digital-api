package com.github.jeffmmartins.digital_bank_api.model;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal; // Importação corrigida
import java.time.LocalDateTime; // Importação corrigida

@Entity
@Table(name = "tb_transacao")
@Setter // CORREÇÃO: Setter global habilitado
@Getter
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // ID continua bloqueado
    private Long id;

    // CORREÇÃO: Usando BigDecimal
    @Column(precision = 19, scale = 2)
    private BigDecimal valorDaTransacao;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoDeTransacao;

    private LocalDateTime dataDaTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "descricao_id")
    private Descricao descricao;

    // Construtor de conveniência (opcional, já que o service usa setters)
    public Transacao(BigDecimal valorDaTransacao, TipoTransacao tipoDeTransacao, LocalDateTime dataDaTransacao, Conta conta) {
        this.valorDaTransacao = valorDaTransacao;
        this.tipoDeTransacao = tipoDeTransacao;
        this.dataDaTransacao = dataDaTransacao;
        this.conta = conta;
    }
}