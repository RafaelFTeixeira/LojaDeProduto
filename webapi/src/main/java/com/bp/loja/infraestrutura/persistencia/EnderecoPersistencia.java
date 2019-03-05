package com.bp.loja.infraestrutura.persistencia;

import com.bp.loja.dominio.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoPersistencia extends JpaRepository<Endereco, Long> {}