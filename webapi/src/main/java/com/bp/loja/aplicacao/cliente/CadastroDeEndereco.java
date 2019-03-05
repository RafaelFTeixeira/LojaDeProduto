package com.bp.loja.aplicacao.cliente;

import com.bp.loja.dominio.Endereco;
import com.bp.loja.infraestrutura.persistencia.EnderecoPersistencia;

import org.springframework.stereotype.Service;

@Service
public class CadastroDeEndereco {
  private EnderecoPersistencia enderecoPersistencia;

  public CadastroDeEndereco(EnderecoPersistencia enderecoPersistencia) {
    this.enderecoPersistencia = enderecoPersistencia;
  }

  public Endereco criar(EnderecoDto enderecoDto) {
    Endereco endereco = new Endereco(enderecoDto.rua, enderecoDto.cidade, enderecoDto.bairro, enderecoDto.cep,
        enderecoDto.estado);
    enderecoPersistencia.save(endereco);

    return endereco;
  }
}