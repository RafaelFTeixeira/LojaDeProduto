package com.bp.loja.aplicacao.categoria;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.infraestrutura.persistencia.CategoriaPersistencia;

import org.springframework.stereotype.Service;

@Service
public class CadastroDeCategoria {
  private CategoriaPersistencia categoriaPersistencia;

  public CadastroDeCategoria(CategoriaPersistencia categoriaPersistencia) {
    this.categoriaPersistencia = categoriaPersistencia;
  }

  public void criar(CategoriaDto categoriaDto) {
    Categoria categoria = new Categoria(categoriaDto.nome);
    categoriaPersistencia.save(categoria);
  }
}