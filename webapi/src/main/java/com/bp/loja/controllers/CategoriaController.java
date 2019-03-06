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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/categorias")
@Api(value = "Categorias", description = "Categorias de um produto")
public class CategoriaController {
  private ConsultaDeCategoria consultaDeCategoria;
  private CadastroDeCategoria cadastroDeCategoria;

  @Autowired
  public CategoriaController(ConsultaDeCategoria consultaDeCategoria, CadastroDeCategoria cadastroDeCategoria) {
    this.consultaDeCategoria = consultaDeCategoria;
    this.cadastroDeCategoria = cadastroDeCategoria;
  }

  @GetMapping
  @ApiOperation(value = "Obter todas as categorias")
  public ResponseEntity<List<CategoriaDto>> obterTodos() {
    List<CategoriaDto> categorias = consultaDeCategoria.obterTodos();

    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation(value = "Cadastro de categoria")
  public void criar(@RequestBody CategoriaDto categoriaDto) {
    cadastroDeCategoria.criar(categoriaDto);
  }
}