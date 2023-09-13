package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.AlertPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class AlertTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage page = new AlertPage();

    @Before
    public void setup() throws MalformedURLException {
        menu.acessarAlerta();
    }

    @Test

    public void deveConfirmarAlerta() throws MalformedURLException {

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

    @Test

    public void deveClicarForaAlerta() throws MalformedURLException {

        //clicar alerta simples
        page.clicarAlertaSimples();

        //clicar fora da caixa 530 1230
        page.clicarForaCaixa();

        //verificar que a mensagem não existe mais
        Assert.assertTrue(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

    }
}
