package com.julia.core.page;

import com.julia.core.BasePage;

import java.net.MalformedURLException;

public class AbasPage extends BasePage {

    public boolean validarAba1() throws MalformedURLException {
        return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public void acessarAba2() throws MalformedURLException {
        clicarPorTexto("Aba 2");
    }

    public boolean validarAba2() throws MalformedURLException {
        return existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }

}
