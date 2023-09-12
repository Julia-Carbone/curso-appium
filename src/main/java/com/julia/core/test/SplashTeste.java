package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import com.julia.core.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() throws MalformedURLException {

        //acessar menu splash
        menu.acessarSplash();

        //verificar que o splash está sendo exibido
        page.isTelaSplashVisivel();

        // aguardar saída do splash
        page.aguardarSplashSumir();

        //verificar que o formulario está aparecendo
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));

    }

}
