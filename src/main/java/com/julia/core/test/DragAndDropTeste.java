package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.DragAndDropPage;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class DragAndDropTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    private DragAndDropPage page = new DragAndDropPage();

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};

    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};

    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test

    public void deveRealizarDragAndDrop() throws MalformedURLException, InterruptedException {

        //acessar menu drag n drop
        esperar(1000);
        menu.acessarDragAndDrop();

        //verificar estado inicial
        esperar(1000);
        Assert.assertArrayEquals(estadoInicial, page.obterLista());

        //arrastar 'Esta' para 'e arraste para'
        page.arrastar("Esta", "e arraste para");
        esperar(1000);

        //verificar estado intermediário
        Assert.assertArrayEquals(estadoIntermediario, page.obterLista());

        //arrastar 'Faça um clique longo' para 'é uma lista'                              
        page.arrastar("Faça um clique longo,", "é uma lista");

        //verificar estado final
        Assert.assertArrayEquals(estadoFinal, page.obterLista());


    }

}
