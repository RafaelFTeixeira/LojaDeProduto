package com.bp.loja.aplicacao.produto;

import java.util.List;
import java.util.stream.Collectors;

import com.bp.loja.aplicacao.categoria.CategoriaMapeada;
import com.bp.loja.dominio.Produto;
import com.bp.loja.infraestrutura.persistencia.ProdutoPersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaDeProduto {
  private ProdutoPersistencia produtoPersistencia;

  @Autowired
  public ConsultaDeProduto(ProdutoPersistencia produtoPersistencia) {
    this.produtoPersistencia = produtoPersistencia;
  }

  @Transactional(readOnly = true)
  public List<ProdutoDto> obterTodos() {
    List<Produto> produtos = produtoPersistencia.findAll();
    return produtos.stream().map(this::mapearProdutoDto).collect(Collectors.toList());
  }

  private ProdutoDto mapearProdutoDto(Produto produto) {
    ProdutoDto produtoDto = new ProdutoDto();
    produtoDto.id = produto.getId();
    produtoDto.nome = produto.getNome();
    produtoDto.descricao = produto.getDescricao();
    produtoDto.preco = produto.getPreco();
    produtoDto.quantidade = produto.getQuantidade();
    produtoDto.categoria = CategoriaMapeada.mapearCategoriaDto(produto.getCategoria());
    produtoDto.caminhoDaImagem = produto.getCaminhoDaImagem();

    return produtoDto;
  }
}