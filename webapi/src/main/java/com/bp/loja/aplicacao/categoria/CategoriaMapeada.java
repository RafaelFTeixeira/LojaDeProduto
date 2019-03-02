package com.bp.loja.aplicacao.categoria;

import com.bp.loja.dominio.Categoria;

public final class CategoriaMapeada {
  public static CategoriaDto mapearCategoriaDto(Categoria categoria) {
    CategoriaDto categoriaDto = new CategoriaDto();
    categoriaDto.id = categoria.getId();
    categoriaDto.nome = categoria.getNome();

    return categoriaDto;
  }
}