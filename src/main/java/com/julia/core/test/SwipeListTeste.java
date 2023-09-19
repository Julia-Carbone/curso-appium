package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import com.julia.core.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SwipeListTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    private SwipeListPage page = new SwipeListPage();

    @Test

    public void deveInteragirSwipeList() throws MalformedURLException {

        //acessar menu swipe
        esperar(1000);
        menu.acessarSwipeList();

        //swipe pra esquerda op1
        page.swipeElementLeft("Opção 1");

        //clicar no +
        page.clicarBotaoMais();

        //verificar op1+
        Assert.assertEquals("Opção 1 (+)", page.obterTexto(By.xpath("//*[@text='Opção 1 (+)']")));

        //swipe pra esquerda op4
        page.swipeElementLeft("Opção 4");

        //clicar no -
        page.clicar(By.xpath("//android.widget.TextView[@text='(-)']"));

        //verificar op4-
        Assert.assertEquals("Opção 4 (-)", page.obterTexto(By.xpath("//*[@text='Opção 4 (-)']")));

        //swipe pra direita op5
        page.swipeElementRight("Opção 5 (-)");

        //verificar op5
        Assert.assertEquals("Opção 5", page.obterTexto(By.xpath("//*[@text='Opção 5']")));


    }
}
