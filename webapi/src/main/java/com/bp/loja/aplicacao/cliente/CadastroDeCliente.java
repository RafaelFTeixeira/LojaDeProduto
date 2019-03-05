package com.bp.loja.aplicacao.cliente;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;
import com.bp.loja.infraestrutura.persistencia.ClientePersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDeCliente {
  private ClientePersistencia clientePersistencia;
  private CadastroDeEndereco cadastroDeEndereco;

  @Autowired
  public CadastroDeCliente(ClientePersistencia clientePersistencia, CadastroDeEndereco cadastroDeEndereco) {
    this.clientePersistencia = clientePersistencia;
    this.cadastroDeEndereco = cadastroDeEndereco;
  }

  public void criar(ClienteDto clienteDto) {
    Endereco endereco = cadastroDeEndereco.criar(clienteDto.endereco);
    Cliente cliente = new Cliente(clienteDto.nome, clienteDto.email, clienteDto.senha, endereco);
    clientePersistencia.save(cliente);
  }
}