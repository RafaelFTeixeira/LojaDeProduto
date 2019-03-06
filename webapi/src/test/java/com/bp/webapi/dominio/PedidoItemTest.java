package com.bp.webapi.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import com.bp.loja.dominio.Categoria;
import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;
import com.bp.loja.dominio.ExcecaoDeDominio;
import com.bp.loja.dominio.Pedido;
import com.bp.loja.dominio.PedidoItem;
import com.bp.loja.dominio.Produto;

@RunWith(SpringRunner.class)
public class PedidoItemTest {
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;
    private BigDecimal valor;

    @Before
    public void Init() {
        Categoria categoria = new Categoria("Moto");
        produto = new Produto(categoria, "Fazer 250", BigDecimal.valueOf(15900), 1, "YAMAHA FAZER 250", "");
        Endereco endereco = new Endereco("rua liberdade", "Campo Grande", "Monte Libano", "79004600", "MS");
        Cliente cliente = new Cliente("Rafael", "rafael@email.com", "123", endereco);
        pedido = new Pedido(cliente);
        quantidade = 2;
        valor = BigDecimal.valueOf(100);
    }

    @Test
    public void deve_criar_um_item_do_pedido_com_produto() {
        PedidoItem pedidoItem = new PedidoItem(produto, pedido, quantidade, valor);

        Assert.assertEquals(produto, pedidoItem.getProduto());
    }

    @Test
    public void deve_criar_um_item_do_pedido_vinculado_ao_um_pedido() {
        PedidoItem pedidoItem = new PedidoItem(produto, pedido, quantidade, valor);

        Assert.assertEquals(pedido, pedidoItem.getPedido());
    }

    @Test
    public void deve_criar_um_item_do_pedido_com_quantidade() {
        PedidoItem pedidoItem = new PedidoItem(produto, pedido, quantidade, valor);

        Assert.assertEquals(quantidade, pedidoItem.getQuantidade());
    }

    @Test
    public void deve_criar_um_item_do_pedido_com_valor() {
        PedidoItem pedidoItem = new PedidoItem(produto, pedido, quantidade, valor);

        Assert.assertEquals(valor, pedidoItem.getValor());
    }

    @Test
    public void deve_criar_um_item_do_pedido_com_valor_total_calculado() {
        BigDecimal total = valor.multiply(BigDecimal.valueOf(quantidade));

        PedidoItem pedidoItem = new PedidoItem(produto, pedido, quantidade, valor);

        Assert.assertEquals(total, pedidoItem.getTotal());
    }
    

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_item_do_pedido_sem_pedido() {
        Pedido pedido = null;

        new PedidoItem(produto, pedido, quantidade, valor);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_item_do_pedido_sem_produto() {
        Produto produto = null;

        new PedidoItem(produto, pedido, quantidade, valor);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_item_do_pedido_sem_quantidade() {
        Integer quantidade = null;

        new PedidoItem(produto, pedido, quantidade, valor);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_um_item_do_pedido_sem_valor() {
        BigDecimal valor = null;

        new PedidoItem(produto, pedido, quantidade, valor);
    }
}
