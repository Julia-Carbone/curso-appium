package com.julia.core;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.getDriver;

public class BasePage {


    public void digitar(By by, String texto) throws MalformedURLException {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) throws MalformedURLException {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) throws MalformedURLException {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) throws MalformedURLException {
        clicar((By.xpath("//*[@text='" + texto + "']")));
    }

    public void selecionarCombo(By by, String valor) throws MalformedURLException {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) throws MalformedURLException {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean isSwitchMarcado(By by) throws MalformedURLException {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

}
