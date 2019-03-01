package com.bp.loja.seguranca;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.loja.aplicacao.usuario.UsuarioDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

  protected LoginFilter(String url, AuthenticationManager authenticationManager) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authenticationManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {

    UsuarioDto usuarioDto = new ObjectMapper().readValue(request.getInputStream(), UsuarioDto.class);

    UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(usuarioDto.getUsername(),
        usuarioDto.getPassword(), Collections.emptyList());

    return getAuthenticationManager().authenticate(autenticacao);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain, Authentication auth) throws IOException, ServletException {

    Autenticacao.adicionar(response, auth.getName());
  }
}