package com.bp.loja.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private Categoria() {
    }

    public Categoria(String nome) {
        new ExcecaoDeDominio().quandoEhNuloOuVazio(nome, "Informe o descrição da categoria").entaoDispara();;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
