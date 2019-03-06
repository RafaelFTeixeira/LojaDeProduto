package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.PedidoItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemPersistencia extends JpaRepository<PedidoItem, Long> {}