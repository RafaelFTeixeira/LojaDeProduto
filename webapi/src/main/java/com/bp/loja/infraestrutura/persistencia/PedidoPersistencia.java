package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoPersistencia extends JpaRepository<Pedido, Long> {}