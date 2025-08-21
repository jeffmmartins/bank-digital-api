package com.github.jeffmmartins.digital_bank_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_descricao")
public class Descricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    public Descricao(){}

    public Descricao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
