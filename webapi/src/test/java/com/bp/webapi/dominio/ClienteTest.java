package com.bp.webapi.dominio;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;
import com.bp.loja.dominio.ExcecaoDeDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClienteTest {
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;

    @Before
    public void Init() {
        nome = "Rafael";
        email = "rafael@email.com";
        senha = "654321";
        endereco = new Endereco("Rua da liberdade", "Campo Grande", "Monte Libano", "79004600", "MS");
    }

    @Test
    public void deve_criar_um_cliente_com_nome() {
        Cliente cliente = new Cliente(nome, email, senha, endereco);

        Assert.assertEquals(nome, cliente.getNome());
    }

    @Test
    public void deve_criar_um_cliente_com_email() {
        Cliente cliente = new Cliente(nome, email, senha, endereco);

        Assert.assertEquals(email, cliente.getEmail());
    }

    @Test
    public void deve_criar_um_cliente_com_senha() {
        Cliente cliente = new Cliente(nome, email, senha, endereco);

        Assert.assertEquals(senha, cliente.getSenha());
    }

    @Test
    public void deve_criar_um_cliente_com_endereco() {
        Cliente cliente = new Cliente(nome, email, senha, endereco);

        Assert.assertEquals(endereco, cliente.getEndereco());
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_cliente_sem_nome() {
        String nome = "";

        Cliente cliente = new Cliente(nome, email, senha, endereco);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_cliente_sem_senha() {
        String senha = "";

        Cliente cliente = new Cliente(nome, email, senha, endereco);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_cliente_sem_email() {
        String email = "";

        Cliente cliente = new Cliente(nome, email, senha, endereco);
    }
}
