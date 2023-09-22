package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import com.julia.core.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class WebViewTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    private WebViewPage page = new WebViewPage();
    @Test

    public void deveRealizarLogin() throws MalformedURLException {

        //acessar o menu
        menu.acessarSBHibrido();
        esperar(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("bolodecafe@hotmail.com");

        //preencher senha
        page.setPassword("bolinho@09");

        //logar
        page.botaoEntrar();

        //verificar login
        Assert.assertEquals("Bem vindo, Julia!", page.validarLogin());

    }

    @After

    public void tearDown() throws MalformedURLException {
        page.sairContextoWeb();
    }

}
