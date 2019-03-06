package com.bp.loja.aplicacao.pedido;

import java.util.List;
import java.util.stream.Collectors;

import com.bp.loja.aplicacao.cliente.ClienteMapeado;
import com.bp.loja.dominio.Pedido;
import com.bp.loja.infraestrutura.persistencia.PedidoPersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaDePedido {

  private PedidoPersistencia pedidoPersistencia;

  @Autowired
  public ConsultaDePedido(PedidoPersistencia pedidoPersistencia) {
    this.pedidoPersistencia = pedidoPersistencia;
  }

  @Transactional(readOnly = true)
  public List<PedidoDto> obterTodos() {
    List<Pedido> pedidos = pedidoPersistencia.findAll();
    return pedidos.stream().map(this::mapearPedidoDto).collect(Collectors.toList());
  }

  private PedidoDto mapearPedidoDto(Pedido pedido) {
    PedidoDto pedidoDto = new PedidoDto();
    pedidoDto.cliente = ClienteMapeado.mapearClienteDto(pedido.getCliente());
    pedidoDto.dataDeCriacao = pedido.getDataDeCriacao();
    pedidoDto.Situacao = pedido.getSituacao().toString();
    return pedidoDto;
  }
}