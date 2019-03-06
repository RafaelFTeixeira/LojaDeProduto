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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/pedidos")
@Api(value = "Pedidos", description = "Ações de pedidos")
public class PedidoController {
  private ConsultaDePedido consultaDePedido;
  private CadastroDePedido cadastroDePedido;

  @Autowired
  public PedidoController(ConsultaDePedido consultaDeProduto, CadastroDePedido cadastroDeProduto) {
    this.consultaDePedido = consultaDeProduto;
    this.cadastroDePedido = cadastroDeProduto;
  }

  @GetMapping
  @ApiOperation(value = "Obter todos os pedidos")
  public ResponseEntity<List<PedidoDto>> obterTodos() {
    List<PedidoDto> produtos = consultaDePedido.obterTodos();
    return new ResponseEntity<>(produtos, HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation(value = "Cadastro de pedido")
  public ResponseEntity adicionar(@RequestBody CadastroDePedidoDto pedidoDto) {
    cadastroDePedido.criar(pedidoDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}