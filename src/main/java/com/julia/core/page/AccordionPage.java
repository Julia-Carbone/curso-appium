package com.julia.core.page;

import com.julia.core.BasePage;

import java.net.MalformedURLException;

public class AccordionPage extends BasePage {

    public void clicarOpcao1() throws MalformedURLException {
        clicarPorTexto("Opção 1");
    }

    public boolean validarOpcao1() throws MalformedURLException {
        return existeElementoPorTexto("Esta é a descrição da opção 1");
    }

    //alternativa que não deu certo:
    /*public String obterValorOp1() throws MalformedURLException {
        return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }*/

}
