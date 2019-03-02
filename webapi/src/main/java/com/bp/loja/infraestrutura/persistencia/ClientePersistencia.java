package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePersistencia extends JpaRepository<Cliente, Long> {}