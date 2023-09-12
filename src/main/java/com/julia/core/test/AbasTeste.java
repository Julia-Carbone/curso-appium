package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.AbasPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class AbasTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage page = new AbasPage();

    @Test

    public void deveInteragirComAbas() throws MalformedURLException {

        //acessar menu abas
        menu.acessarAbas();

        //verificar que está na aba 1
        Assert.assertTrue(page.validarAba1());

        //acessar aba 2
        page.acessarAba2();

        //verificar que está na aba 2
        Assert.assertTrue(page.validarAba2());

    }

}
