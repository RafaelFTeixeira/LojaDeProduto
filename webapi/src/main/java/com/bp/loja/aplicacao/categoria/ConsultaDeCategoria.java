package com.bp.loja.aplicacao.categoria;

import java.util.stream.Collectors;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.infraestrutura.persistencia.CategoriaPersistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaDeCategoria {
  private CategoriaPersistencia categoriaPersistencia;

  @Autowired
  public ConsultaDeCategoria(CategoriaPersistencia categoriaPersistencia) {
    this.categoriaPersistencia = categoriaPersistencia;
  }

  @Transactional(readOnly = true)
  public List<CategoriaDto> obterTodos() {
    List<Categoria> categorias = this.categoriaPersistencia.findAll();
    return categorias.stream().map(this::mapearCategoriaDto).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public Optional<CategoriaDto> obterPor(Long id) {
    Optional<Categoria> categoria = this.categoriaPersistencia.findById(id);

    return categoria.map(this::mapearCategoriaDto);
  }

  private CategoriaDto mapearCategoriaDto(Categoria categoria) {
    return CategoriaMapeada.mapearCategoriaDto(categoria);
  }
}