package com.bp.loja.dominio;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Categoria categoria;
  @Column(length = 120)
  private String nome;
  private String descricao;
  private Integer quantidade;
  private BigDecimal preco;
  private String caminhoDaImagem;

  private Produto() {
  }

  public Produto(Categoria categoria, String nome, BigDecimal preco, Integer quantidade, String descricao, String caminhoDaImagem) {
    Validar(categoria, nome, preco, quantidade);
    this.categoria = categoria;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.caminhoDaImagem = caminhoDaImagem;
  }

  private void Validar(Categoria categoria, String nome, BigDecimal preco, Integer quantidade) {
    new ExcecaoDeDominio().quandoEhNulo(categoria, "Informe uma categoria para o produto")
        .quandoEhNuloOuVazio(nome, "Informe um nome para o produto")
        .quandoEhNulo(preco, "Informe um preço para o produto")
        .quandoEhNulo(quantidade, "Informe uma quantidade para o produto").entaoDispara();
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public String getCaminhoDaImagem() {
    return caminhoDaImagem;
  }

  public Long getId() {
    return id;
  }
}