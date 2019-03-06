package com.bp.loja.aplicacao.pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Pedido;
import com.bp.loja.dominio.PedidoItem;
import com.bp.loja.dominio.Produto;
import com.bp.loja.infraestrutura.persistencia.ClientePersistencia;
import com.bp.loja.infraestrutura.persistencia.PedidoItemPersistencia;
import com.bp.loja.infraestrutura.persistencia.PedidoPersistencia;
import com.bp.loja.infraestrutura.persistencia.ProdutoPersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDePedido {
  private ClientePersistencia clientePersistencia;
  private PedidoPersistencia pedidoPersistencia;
  private PedidoItemPersistencia pedidoItemPersistencia;
  private ProdutoPersistencia produtoPersistencia;

  @Autowired
  public CadastroDePedido(ClientePersistencia clientePersistencia, PedidoPersistencia pedidoPersistencia,
      PedidoItemPersistencia pedidoItemPersistencia, ProdutoPersistencia produtoPersistencia) {
    this.clientePersistencia = clientePersistencia;
    this.pedidoPersistencia = pedidoPersistencia;
    this.pedidoItemPersistencia = pedidoItemPersistencia;
    this.produtoPersistencia = produtoPersistencia;
  }

  public void criar(CadastroDePedidoDto pedidoDto) {
    Optional<Cliente> cliente = clientePersistencia.findById(pedidoDto.clienteId);
    Pedido pedido = new Pedido(cliente.get());
    pedidoPersistencia.save(pedido);
    criarItensDoPedido(pedidoDto.produtos, pedido);
  }

  private void criarItensDoPedido(HashMap<Long, Integer> produtos, Pedido pedido) {
    List<PedidoItem> itensDoPedido = new ArrayList<PedidoItem>();
    produtos.forEach((idDoProduto, quantidade) -> {
      Optional<Produto> produto = produtoPersistencia.findById(idDoProduto);

      itensDoPedido.add(new PedidoItem(produto.get(), pedido, quantidade, produto.get().getPreco()));
    });
    pedidoItemPersistencia.saveAll(itensDoPedido);
  }
}