package com.bp.loja.dominio;

import java.util.ArrayList;
import java.util.List;

public class ExcecaoDeDominio extends RuntimeException {
  private List<String> erros = new ArrayList<String>();

  public ExcecaoDeDominio() {
    super();
  }

  public ExcecaoDeDominio quandoEhNuloOuVazio(String texto, String mensagem) {
    if (null == texto || texto.trim() == "") {
      erros.add(mensagem);
    }
    return this;
  }

  public ExcecaoDeDominio quandoEhNulo(Object objeto, String mensagem) {
    if (null == objeto) {
      erros.add(mensagem);
    }
    return this;
  }

  public void entaoDispara() {
    if (erros.isEmpty()) {
      throw this;
    }
  }
}