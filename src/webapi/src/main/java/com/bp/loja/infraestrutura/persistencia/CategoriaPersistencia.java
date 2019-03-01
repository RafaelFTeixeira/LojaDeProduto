package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaPersistencia extends JpaRepository<Categoria, Long> {}