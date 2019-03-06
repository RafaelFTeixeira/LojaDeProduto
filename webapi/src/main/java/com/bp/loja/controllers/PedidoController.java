package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.aplicacao.pedido.CadastroDePedido;
import com.bp.loja.aplicacao.pedido.CadastroDePedidoDto;
import com.bp.loja.aplicacao.pedido.ConsultaDePedido;
import com.bp.loja.aplicacao.pedido.PedidoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
  private ConsultaDePedido consultaDePedido;
  private CadastroDePedido cadastroDePedido;

  @Autowired
  public PedidoController(ConsultaDePedido consultaDeProduto, CadastroDePedido cadastroDeProduto) {
    this.consultaDePedido = consultaDeProduto;
    this.cadastroDePedido = cadastroDeProduto;
  }

  @GetMapping
  public ResponseEntity<List<PedidoDto>> obterTodos() {
    List<PedidoDto> produtos = consultaDePedido.obterTodos();
    return new ResponseEntity<>(produtos, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity adicionar(@RequestBody CadastroDePedidoDto pedidoDto) {
    cadastroDePedido.criar(pedidoDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}