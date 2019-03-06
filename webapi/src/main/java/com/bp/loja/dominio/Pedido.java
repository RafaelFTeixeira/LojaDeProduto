package com.bp.loja.dominio;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime dataDeCriacao;
  private Situacao situacao;
  @ManyToOne
  private Cliente cliente;

  private Pedido() {
  }

  public Pedido(Cliente cliente) {
    validar(cliente);
    this.situacao = situacao.PENDENTE;
    this.dataDeCriacao = LocalDateTime.now();
    this.cliente = cliente;
  }

  private void validar(Cliente cliente) {
    new ExcecaoDeDominio()
      .quandoEhNulo(cliente, "O cliente é obrigatório")
      .entaoDispara();
  }

  public void finalizar() {
    this.situacao = Situacao.FINALIZADO;
  }

  public void cancelar() {
    this.situacao = Situacao.CANCELADO;
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getDataDeCriacao() {
    return dataDeCriacao;
  }

  public Situacao getSituacao() {
    return situacao;
  }

  public Cliente getCliente() {
    return cliente;
  }
}