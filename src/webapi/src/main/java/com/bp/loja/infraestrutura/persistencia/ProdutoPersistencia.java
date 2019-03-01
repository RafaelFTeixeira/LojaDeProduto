package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPersistencia extends JpaRepository<Produto, Long> {}