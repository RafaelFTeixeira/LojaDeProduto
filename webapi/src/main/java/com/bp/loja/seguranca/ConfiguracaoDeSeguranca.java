package com.bp.loja.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Profile("producao")
public class ConfiguracaoDeSeguranca extends WebSecurityConfigurerAdapter {
  private static final String[] LISTA_DE_AUTORIZACAO = {
    "/swagger-resources",
    "/swagger-resources/**",
    "/swagger-ui.html",
    "/v2/api-docs",
    "/h2-console/**",
    "/configuration/ui",
    "/configuration/security",
    "/webjars/**"
};

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers(LISTA_DE_AUTORIZACAO).permitAll()
        .anyRequest().authenticated().and()
        .addFilterBefore(new LoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new AutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);

    httpSecurity.headers().frameOptions().disable();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .passwordEncoder(NoOpPasswordEncoder.getInstance())
      .withUser("dolores")
      .password("54321")
      .roles("USER");
  }
}