package com.bp.loja.aplicacao.produto;

import java.math.BigDecimal;

import com.bp.loja.aplicacao.categoria.CategoriaDto;

public class ProdutoDto {
  public Long id;
  public CategoriaDto categoria;
  public String nome;
  public BigDecimal preco;
  public Integer quantidade;
  public String descricao;
  public String caminhoDaImagem;
}