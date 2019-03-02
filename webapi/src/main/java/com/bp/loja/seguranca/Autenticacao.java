package com.bp.loja.seguranca;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Autenticacao {
  static final long TEMPO_DE_EXPIRACAO = 860_000_000;
  static final String SECRET = "MySecret";
  static final String HEADER = "Authorization";
  static final String TIPO_DE_TOKEN = "Bearer";

  static void adicionar(HttpServletResponse response, String loginDoUsuario) {
    Date expiracaoDoToken = new Date(System.currentTimeMillis() + TEMPO_DE_EXPIRACAO);
    String JWT = Jwts.builder().setSubject(loginDoUsuario).setExpiration(expiracaoDoToken)
        .signWith(SignatureAlgorithm.HS512, SECRET).compact();

    response.addHeader(HEADER, TIPO_DE_TOKEN + " " + JWT);
  }

  static Authentication obter(HttpServletRequest request) {
    String token = request.getHeader(HEADER);

    if (token != null) {
      String usuario = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TIPO_DE_TOKEN, "")).getBody()
          .getSubject();

      if (usuario != null) {
        return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
      }
    }

    return null;
  }
}