package com.bp.loja.aplicacao.cliente;

import java.util.List;
import java.util.stream.Collectors;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.infraestrutura.persistencia.ClientePersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaDeCliente {
  private ClientePersistencia clientePersistencia;

  @Autowired
  public ConsultaDeCliente(ClientePersistencia clientePersistencia) {
    this.clientePersistencia = clientePersistencia;
  }

  @Transactional(readOnly = true)
  public List<ClienteDto> obterTodos() {
    List<Cliente> clientes = clientePersistencia.findAll();
    return clientes.stream().map(this::mapearClienteDto).collect(Collectors.toList());
  }

  private ClienteDto mapearClienteDto(Cliente cliente) {
    return ClienteMapeado.mapearClienteDto(cliente);
  }
}