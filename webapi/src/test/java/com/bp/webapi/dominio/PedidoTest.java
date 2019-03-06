package com.bp.webapi.dominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;
import com.bp.loja.dominio.ExcecaoDeDominio;
import com.bp.loja.dominio.Pedido;
import com.bp.loja.dominio.Situacao;

@RunWith(SpringRunner.class)
public class PedidoTest {
    private Endereco endereco;
    private Cliente cliente;

    @Before
    public void Init() {
        endereco = new Endereco("rua liberdade", "Campo Grande", "Monte Libano", "79004600", "MS");
        cliente = new Cliente("Rafael", "rafael@email.com", "123", endereco);
    }

    @Test
    public void deve_criar_um_pedido_com_cliente() {
        Pedido pedido = new Pedido(cliente);

        Assert.assertEquals(cliente, pedido.getCliente());
    }

    @Test
    public void deve_criar_um_pedido_com_situacao_pendente() {
        Situacao situacao = Situacao.PENDENTE;

        Pedido pedido = new Pedido(cliente);

        Assert.assertEquals(situacao, pedido.getSituacao());
    }

    @Test
    public void deve_criar_um_pedido_com_data_de_criacao_atual() {
        LocalDateTime dataDeCriacao = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente);

        Assert.assertEquals(dataDeCriacao.truncatedTo(ChronoUnit.SECONDS),
                pedido.getDataDeCriacao().truncatedTo(ChronoUnit.SECONDS));
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_pedido_sem_cliente() {
        new Pedido(null);
    }
}
