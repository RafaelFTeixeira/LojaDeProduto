package com.bp.webapi.dominio;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.dominio.ExcecaoDeDominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CategoriaTest {
    @Test
    public void deve_criar_uma_categoria(){
        String nome = "Moto";

        Categoria categoria = new Categoria(nome);

        Assert.assertEquals(nome, categoria.getNome());
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_uma_categoria_vazia(){
        String nomeDaCategoria = "";

        new Categoria(nomeDaCategoria);
    }
}