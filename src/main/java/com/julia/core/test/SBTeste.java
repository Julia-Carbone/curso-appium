package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import com.julia.core.page.seuBarriga.SBContasPage;
import com.julia.core.page.seuBarriga.SBLoginPage;
import com.julia.core.page.seuBarriga.SBNativoMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class SBTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBNativoMenuPage menuSB = new SBNativoMenuPage();

    private SBContasPage contas = new SBContasPage();

    @Before
    public void setup() throws MalformedURLException {
        menu.acessarSBNativo();
        login.setEmail("bolinho@hotmail.com");
        login.setSenha("bolinho@09");
        login.entrar();
    }

    @Test

    public void inserirConta() throws MalformedURLException {

        //entrar em contas
        menuSB.acessarConta();

        //preencher campo
        contas.setConta("Conta de Teste");

        //salvar
        contas.salvar();

        //validar mensagem
       Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));

    }

    @Test

    public void deveExcluirConta() throws MalformedURLException {

        //entrar em contas
        menuSB.acessarConta();

        //clique longo na conta
        contas.selecionarConta("Conta de Teste");

        //excluir
        contas.excluir();

        //validar mensagem
        Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
    }

}
