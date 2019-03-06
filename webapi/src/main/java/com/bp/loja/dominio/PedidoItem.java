package com.bp.loja.dominio;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class PedidoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Produto produto;
  @ManyToOne
  private Pedido pedido;
  private Integer quantidade;
  private BigDecimal valor;
  private BigDecimal total;

  private PedidoItem() {
  }

  public PedidoItem(Produto produto, Pedido pedido, Integer quantidade, BigDecimal valor) {
    validar(produto, pedido, quantidade, valor);

    this.produto = produto;
    this.pedido = pedido;
    this.quantidade = quantidade;
    this.valor = valor;
    this.total = valor.multiply(BigDecimal.valueOf(quantidade));
  }

  private void validar(Produto produto, Pedido pedido, Integer quantidade, BigDecimal valor) {
    new ExcecaoDeDominio()
        .quandoEhNulo(produto, "O produto é obrigatório")
        .quandoEhNulo(valor, "O valor é obrigatório")
        .quandoEhNulo(pedido, "O pedido é obrigatório")
        .quandoEhNulo(quantidade, "A quantidade é obrigatório")
        .entaoDispara();
  }

  public Long getId() {
    return id;
  }

  public Produto getProduto() {
    return produto;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public BigDecimal getTotal() {
    return total;
  }
}