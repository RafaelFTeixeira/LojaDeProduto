package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.infraestrutura.persistencia.ClientePersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
  private ClientePersistencia clientePersitencia;

  @Autowired
  public ClienteController(ClientePersistencia clientePersistencia) {
    this.clientePersitencia = clientePersistencia;
  }

  @GetMapping
  public ResponseEntity<List<Cliente>> obterTodos() {
    List<Cliente> clientes = clientePersitencia.findAll();

    return new ResponseEntity<>(clientes, HttpStatus.OK);
  }
 
}