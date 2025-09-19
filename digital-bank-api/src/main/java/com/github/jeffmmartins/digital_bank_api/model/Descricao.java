package com.github.jeffmmartins.digital_bank_api.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_descricao")
@Getter
@Setter
@NoArgsConstructor
public class Descricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String titulo;

    private String descricao;

    @OneToMany(mappedBy = "descricao", fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    private List<Transacao> transacoes = new ArrayList<>();


    public Descricao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}
