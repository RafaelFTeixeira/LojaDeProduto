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

  public Produto(Categoria categoria, String nome, BigDecimal preco, Integer quantidade, String descricao,
      String caminhoDaImagem) {
    validarCamposObrigatorios(categoria, nome, preco, quantidade);
    this.categoria = categoria;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
    this.caminhoDaImagem = caminhoDaImagem;
  }

  private static void validarCamposObrigatorios(Categoria categoria, String nome, BigDecimal preco, Integer quantidade) {
    new ExcecaoDeDominio()
        .quandoEhNulo(categoria, "A categoria é obrigatória")
        .quandoEhNuloOuVazio(nome, "O nome é obrigatório")
        .quandoEhNulo(preco, "O preço é obrigatório")
        .quandoEhNulo(quantidade, "A quantidade é obrigatória")
        .entaoDispara();
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