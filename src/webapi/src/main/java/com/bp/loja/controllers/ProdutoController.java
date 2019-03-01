package com.bp.loja.controllers;

import java.util.List;

import com.bp.loja.aplicacao.produto.CadastroDeProduto;
import com.bp.loja.aplicacao.produto.ConsultaDeProduto;
import com.bp.loja.aplicacao.produto.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  private ConsultaDeProduto consultaDeProduto;
  private CadastroDeProduto cadastroDeProduto;

  @Autowired
  public ProdutoController(ConsultaDeProduto consultaDeProduto, CadastroDeProduto cadastroDeProduto) {
    this.consultaDeProduto = consultaDeProduto;
    this.cadastroDeProduto = cadastroDeProduto;
  }

  @GetMapping
  public ResponseEntity<List<ProdutoDto>> obterTodos() {
    List<ProdutoDto> produtos = consultaDeProduto.obterTodos();
    return new ResponseEntity<>(produtos, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity adicionar(@RequestBody ProdutoDto produtoDto) {
    cadastroDeProduto.criar(produtoDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}