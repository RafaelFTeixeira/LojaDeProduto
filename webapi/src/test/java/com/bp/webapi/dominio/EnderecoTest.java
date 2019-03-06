package com.bp.webapi.dominio;

import com.bp.loja.dominio.Endereco;
import com.bp.loja.dominio.ExcecaoDeDominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EnderecoTest {
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;

    @Before
    public void Init() {
        rua = "Liberdade";
        bairro = "Monte Libano";
        cep = "79004600";
        cidade = "Campo Grande";
        estado = "MS";
    }

    @Test
    public void deve_criar_um_endereco_com_rua() {
        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(rua, endereco.getRua());
    }

    @Test
    public void deve_criar_um_endereco_com_bairro() {
        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(bairro, endereco.getBairro());
    }

    @Test
    public void deve_criar_um_endereco_com_cep() {
        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(cep, endereco.getCep());
    }

    @Test
    public void deve_criar_um_endereco_com_cidade() {
        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(cidade, endereco.getCidade());
    }

    @Test
    public void deve_criar_um_endereco_com_estado() {
        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);

        Assert.assertEquals(estado, endereco.getEstado());
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_endereco_com_cep_vazio() {
        String cep = "";

        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_endereco_com_rua_vazio() {
        String rua = "";

        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_endereco_com_bairro_vazio() {
        String bairro = "";

        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_endereco_com_cidade_vazio() {
        String cidade = "";

        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);
    }

    @Test(expected = ExcecaoDeDominio.class)
    public void nao_deve_criar_endereco_com_estado_vazio() {
        String estado = "";

        Endereco endereco = new Endereco(rua, cidade, bairro, cep, estado);
    }
}
