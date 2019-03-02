package com.bp.loja.aplicacao.produto;

import java.util.Optional;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.dominio.Produto;
import com.bp.loja.infraestrutura.persistencia.CategoriaPersistencia;
import com.bp.loja.infraestrutura.persistencia.ProdutoPersistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroDeProduto {
  private ProdutoPersistencia produtoPersistencia;
  private CategoriaPersistencia categoriaPersistencia;

  @Autowired
  public CadastroDeProduto(ProdutoPersistencia produtoPersistencia, CategoriaPersistencia categoriaPersistencia) {
    this.produtoPersistencia = produtoPersistencia;
    this.categoriaPersistencia = categoriaPersistencia;
  }

  public void criar(ProdutoDto produtoDto) {
    Optional<Categoria> categoria = categoriaPersistencia.findById(produtoDto.categoria.id);
    Produto produto = new Produto(categoria.get(), produtoDto.nome, produtoDto.preco, produtoDto.quantidade,
        produtoDto.descricao, produtoDto.caminhoDaImagem);
    produtoPersistencia.save(produto);
  }
}