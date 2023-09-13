package com.julia.core.test;

import com.julia.core.BaseTest;
import com.julia.core.DriverFactory;
import com.julia.core.page.FormularioPage;
import com.julia.core.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class formularioDesafio extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        //escrever nome
        page.escreverNome("Julia");

        //checar nome escrito
        assertEquals("Julia", page.obterNome());
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {
        // clicar no combo
        page.selecionarCombo("Nintendo Switch");

        // verificar opção selecionada
        assertEquals("Nintendo Switch", page.obterValorCombo());
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {

        // verificar status dos elementos
        Assert.assertFalse(page.isCheckMarcado());
        Assert.assertTrue(page.isSwitchMarcado());

        // clicar nos elementos
        page.clicarCheck();
        page.clicarSwitch();

        // verificar estados alterados
        Assert.assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());

    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {

        // preencher campos
        page.escreverNome("Julia");
        page.clicarCheck();
        page.clicarSwitch();
        page.selecionarCombo("Nintendo Switch");

        // salvar
        page.salvar();

        // verificar campos preenchidos
        Assert.assertEquals("Nome: Julia", page.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
        Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
        Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));


    }

    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        // preencher campos
        page.escreverNome("Julia");


        // salvar
        page.salvarDemorado();

        //esperar(3000);
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Julia']"))); //esperar até que a condição aconteça

        // verificar campos preenchidos
        Assert.assertEquals("Nome: Julia", page.obterNomeCadastrado());
    }

    @Test

            public void deveAlterarData() throws MalformedURLException {
                page.clicarPorTexto("01/01/2000");
                page.clicarPorTexto("20");
                page.clicarPorTexto("OK");
                Assert.assertTrue(page.existeElementoPorTexto("20/01/2000"));
        }
    @Test

    public void deveAlterarHora() throws MalformedURLException {
        page.clicarPorTexto("12:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("35"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:35"));
    }

    }

