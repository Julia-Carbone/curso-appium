package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.CliquesPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class CliquesTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    private CliquesPage page = new CliquesPage();

    @Test
    public void deveRealizarCliqueLongo() throws MalformedURLException {

        //acessar menu clique
        menu.acessarClique();

        //pressionar clique longo
        page.cliqueLongo();

        //verificar campo texto
        Assert.assertEquals("Clique Longo", page.validarCampoTexto());

    }

    @Test
    public void deveInteragirCliqueDuplo() throws MalformedURLException {

        //acessar menu clique
        menu.acessarClique();

        //clique duplo
        page.deveDarCliqueDuplo();

        //verificar campo texto
        Assert.assertEquals("Duplo Clique", page.deveVerificarCampoTexto());
    }
}
