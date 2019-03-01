package com.bp.loja.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

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
    if (Objects.isNull(objeto)) {
      erros.add(mensagem);
    }
    return this;
  }

  public void entaoDispara() {
    if (!erros.isEmpty()) {
      throw this;
    }
  }

  @Override
  public String toString() {
    StringJoiner stringJoiner = new StringJoiner("/n");
    erros.forEach(stringJoiner::add);

    return stringJoiner.toString();
  }
}