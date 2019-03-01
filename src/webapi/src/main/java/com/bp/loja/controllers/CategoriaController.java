package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.aplicacao.categoria.CategoriaDto;
import com.bp.loja.aplicacao.categoria.ConsultaDeCategoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
  private ConsultaDeCategoria consultaDeCategoria;

  public CategoriaController(ConsultaDeCategoria consultaDeCategoria) {
    this.consultaDeCategoria = consultaDeCategoria;
  }

  @GetMapping
  public ResponseEntity<List<CategoriaDto>> obterTodos() {
    List<CategoriaDto> categorias = consultaDeCategoria.obterTodos();

    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }
}