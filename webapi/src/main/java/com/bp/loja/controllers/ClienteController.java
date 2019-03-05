package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.aplicacao.cliente.CadastroDeCliente;
import com.bp.loja.aplicacao.cliente.ClienteDto;
import com.bp.loja.aplicacao.cliente.ConsultaDeCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
  private ConsultaDeCliente consultaDeCliente;
  private CadastroDeCliente cadastroDeCliente;

  @Autowired
  public ClienteController(ConsultaDeCliente consultaDeCliente, CadastroDeCliente cadastroDeCliente) {
    this.consultaDeCliente = consultaDeCliente;
    this.cadastroDeCliente= cadastroDeCliente; 
  }

  @GetMapping
  public ResponseEntity<List<ClienteDto>> obterTodos() {
    List<ClienteDto> clientes = consultaDeCliente.obterTodos();
    return new ResponseEntity<>(clientes, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity adicionar(@RequestBody ClienteDto ClienteDto) {
    cadastroDeCliente.criar(ClienteDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}