package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;

import java.net.MalformedURLException;

public class SBNativoMenuPage extends BasePage {


    public void acessarConta() throws MalformedURLException {
        clicarPorTexto("Contas");
    }

    public void acessarMovimentacao() throws MalformedURLException {
        clicarPorTexto("Mov...");
    }
}
