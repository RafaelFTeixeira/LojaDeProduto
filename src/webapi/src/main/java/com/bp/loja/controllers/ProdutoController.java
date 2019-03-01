package com.bp.loja.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  public ProdutoController() {

  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String obterTeste() {
    return "Rafael";
  }
}