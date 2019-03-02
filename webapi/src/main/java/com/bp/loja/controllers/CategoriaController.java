package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.aplicacao.categoria.CadastroDeCategoria;
import com.bp.loja.aplicacao.categoria.CategoriaDto;
import com.bp.loja.aplicacao.categoria.ConsultaDeCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
  private ConsultaDeCategoria consultaDeCategoria;
  private CadastroDeCategoria cadastroDeCategoria;

  @Autowired
  public CategoriaController(ConsultaDeCategoria consultaDeCategoria, CadastroDeCategoria cadastroDeCategoria) {
    this.consultaDeCategoria = consultaDeCategoria;
    this.cadastroDeCategoria = cadastroDeCategoria;
  }

  @GetMapping
  public ResponseEntity<List<CategoriaDto>> obterTodos() {
    List<CategoriaDto> categorias = consultaDeCategoria.obterTodos();

    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }

  @PostMapping
  public void criar(@RequestBody CategoriaDto categoriaDto) {
    cadastroDeCategoria.criar(categoriaDto);
  }
}