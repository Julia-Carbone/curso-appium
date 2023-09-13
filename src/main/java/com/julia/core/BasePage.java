package com.julia.core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

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

    public boolean existeElementoPorTexto(String texto) throws MalformedURLException {
        List<WebElement> elementos = (List<WebElement>) getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
        //como é booleano, quando formos declarar essa funcao em um metodo ele precisa ser booleano tmb
    }

    //método de coordenadas
    public void tap(int x, int y) throws MalformedURLException {

        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();

    }

}
