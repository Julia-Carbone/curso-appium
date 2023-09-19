package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SwipeTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveInteragirComSwipe() throws MalformedURLException {

        //acessar menu swipe
        esperar(1000);
        menu.acessarSwipe();

        //verificar texto 'a esquerda'
        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        //swipe para direita
        menu.swipeRight();

        //verificar texto
        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        //clicar no botão na direita
        menu.swipeRight();

        //verificar texto 'Chegar até o fim!'
        Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        //swipe para esquerda
        menu.swipeLeft();

        //clicar no botão da esquerda
        menu.swipeLeft();

        //verificar texto
        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

    }
}
