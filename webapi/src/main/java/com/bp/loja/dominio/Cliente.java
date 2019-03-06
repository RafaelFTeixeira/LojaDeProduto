package com.bp.loja.dominio;

import javax.persistence.*;

@Entity
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String senha;
  @ManyToOne
  private Endereco endereco;

  private Cliente() {
  }

  public Cliente(String nome, String email, String senha, Endereco endereco) {
    validarCamposObrigatorios(nome, email, senha);
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.endereco = endereco;
  }

  private static void validarCamposObrigatorios(String nome, String email, String senha) {
    new ExcecaoDeDominio()
      .quandoEhNuloOuVazio(nome, "O nome é obrigatório")
      .quandoEhNuloOuVazio(email, "O e-mail é obrigatório")
      .quandoEhNuloOuVazio(senha, "A senha é obrigatória")
      .entaoDispara();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

  public Endereco getEndereco() {
    return endereco;
  }
}
