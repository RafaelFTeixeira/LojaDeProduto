package com.bp.loja.aplicacao.cliente;

import java.util.List;
import java.util.stream.Collectors;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;
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
    ClienteDto clienteDto = new ClienteDto();
    EnderecoDto enderecoDto = mapearEnderecoDto(cliente.getEndereco());

    clienteDto.id = cliente.getId();
    clienteDto.nome = cliente.getNome();
    clienteDto.email = cliente.getEmail();
    clienteDto.endereco = enderecoDto;

    return clienteDto;
  }

  private EnderecoDto mapearEnderecoDto(Endereco endereco) {
    EnderecoDto enderecoDto = new EnderecoDto();
    if (null != endereco) {
      enderecoDto.cidade = endereco.getCidade();
      enderecoDto.estado = endereco.getEstado();
      enderecoDto.cep = endereco.getCep();
      enderecoDto.rua = endereco.getRua();
      enderecoDto.bairro = endereco.getBairro();
    }
    return enderecoDto;
  }
}