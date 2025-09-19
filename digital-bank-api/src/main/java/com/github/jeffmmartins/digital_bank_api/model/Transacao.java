package com.github.jeffmmartins.digital_bank_api.model;

import com.github.jeffmmartins.digital_bank_api.model.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transacao")
@Setter
@Getter
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter(AccessLevel.NONE)
    private Double valorDaTransacao;

    @Setter(AccessLevel.NONE)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoDeTransacao;

    @Setter(AccessLevel.NONE)
    private LocalDateTime dataDaTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Conta conta;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "descricao_id")
    private Descricao descricao;

    public Transacao(Double valorDaTransacao, TipoTransacao tipoDeTransacao, LocalDateTime dataDaTransacao) {
        this.valorDaTransacao = valorDaTransacao;
        this.tipoDeTransacao = tipoDeTransacao;
        this.dataDaTransacao = dataDaTransacao;
    }
}
