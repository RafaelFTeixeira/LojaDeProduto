package com.bp.loja.aplicacao.pedido;

import java.time.LocalDateTime;

import com.bp.loja.aplicacao.cliente.ClienteDto;

public class PedidoDto {
  public LocalDateTime dataDeCriacao;
  public String Situacao;
  public ClienteDto cliente;
}