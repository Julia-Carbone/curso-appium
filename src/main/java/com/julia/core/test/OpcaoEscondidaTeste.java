package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.getDriver;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test

    public void deveEncontrarOpcaoEscondida() throws MalformedURLException {

        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(), 10); //pedimos pra esperar até que a tela esteja pronta, no caso até que ele veja o elemento 'formulario'
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando"); //só para acompanhar melhor a automação

        menu.scrollDown(0.9, 0.1);

        //clicar menu
        menu.clicarPorTexto("Opção bem escondida");

        //verificar mensagem
        Assert.assertEquals("Sucesso", menu.obterTituloAlerta());

        //sair
        menu.clicarPorTexto("OK");

    }
}
