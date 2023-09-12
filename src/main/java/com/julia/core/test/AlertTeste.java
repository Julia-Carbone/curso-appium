package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.AlertPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class AlertTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage page = new AlertPage();

    @Test

    public void deveConfirmarAlerta() throws MalformedURLException {

        //acessar menu alerta
        menu.acessarAlerta();

        //clicar em 'alert confirm'
        page.clicarAlertaConfirm();

        //verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        //confirmar alerta
        page.ConfirmarAlerta();

        //verificar nova mensagem
        Assert.assertEquals("Confirmado", page.obterMensagemConfirmadoAlerta());

        //sair
        page.SairAlerta();

    }
}
