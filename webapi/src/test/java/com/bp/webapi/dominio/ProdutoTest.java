package com.bp.webapi.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.dominio.ExcecaoDeDominio;
import com.bp.loja.dominio.Produto;

@RunWith(SpringRunner.class)
public class ProdutoTest {

    private String nome;
    private BigDecimal preco;
    private int quantidade;
    private String descricao;
    private String caminhoDaImagem;
    private Categoria categoria;

    @Before
    public void init(){
        nome = "MT 03";
        descricao = "Yamaha MT 03";
        preco = BigDecimal.valueOf(23000);
        quantidade = 1;
        caminhoDaImagem = "localhost:9898/imagem.jpg";
        categoria = new Categoria("Moto");
    }

    @Test
    public void deve_criar_um_produto_com_nome(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(nome, produtoCriado.getNome());
    }
    @Test
    public void deve_criar_um_produto_com_preco(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(preco, produtoCriado.getPreco());
    }
    @Test
    public void deve_criar_um_produto_com_quantidade(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(quantidade, produtoCriado.getQuantidade());
    }
    @Test
    public void deve_criar_um_produto_com_descricao(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(descricao, produtoCriado.getDescricao());
    }

    @Test
    public void deve_criar_um_produto_com_caminho_da_imagem(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(caminhoDaImagem, produtoCriado.getCaminhoDaImagem());
    }

    @Test
    public void deve_criar_um_produto_com_categoria(){
        Produto produtoCriado = new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);

        Assert.assertEquals(categoria, produtoCriado.getCategoria());
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_produto_sem_categoria(){
        Categoria categoria = null;

        new Produto(categoria, nome, preco, quantidade, descricao, caminhoDaImagem);
    }
}
