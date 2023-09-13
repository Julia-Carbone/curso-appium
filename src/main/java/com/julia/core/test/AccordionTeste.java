package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.AccordionPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class AccordionTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test

    public void deveInteragirComAccordion() throws MalformedURLException {

        //acessar menu accordion
        menu.acessarAccordion();

        //clicar na opção 1
        page.clicarOpcao1();

        //validar texto da op1
        Assert.assertTrue("Esta é a descrição da opção 1", page.validarOpcao1());

        //Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1()); - alternativa
    }
}
