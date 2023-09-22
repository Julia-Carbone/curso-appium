package com.julia.core.page;

import com.julia.core.BasePage;

import java.net.MalformedURLException;

public class MenuPage extends BasePage {

    public void acessarFormulario() throws MalformedURLException {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() throws MalformedURLException {
        clicarPorTexto("Splash");
    }

    public void acessarAlerta() throws MalformedURLException {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() throws MalformedURLException {
        clicarPorTexto("Abas");
    }

    public void acessarAccordion() throws MalformedURLException {
        clicarPorTexto("Accordion");
    }

    public void acessarClique() throws MalformedURLException {
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe() throws MalformedURLException {
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList() throws MalformedURLException {
        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop() throws MalformedURLException {
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido() throws MalformedURLException {
        clicarPorTexto("SeuBarriga Híbrido");
    }
}
