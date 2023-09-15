package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.CliqueLongoPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class CliqueLongoTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    private CliqueLongoPage page = new CliqueLongoPage();

    @Test
    public void deveRealizarCliqueLongo() throws MalformedURLException {

        //acessar menu clique
        menu.acessarClique();

        //pressionar clique longo
        page.longPress();

        //verificar campo texto
        Assert.assertEquals("Clique Longo", page.validarCampoTexto());


    }

}
