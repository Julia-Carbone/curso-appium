package com.julia.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
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

    public String obterTituloAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/message"));
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
        //como é booleano, quando formos declarar essa funcao em um metodo ele precisa ser booleano tmb, no caso vai ser 'Assert true'
    }

    //método de coordenadas
    public void tap(int x, int y) throws MalformedURLException {

        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();

    }

    public void scroll(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * inicio);
        int endY = (int) (size.height * fim);

        new TouchAction(getDriver()).press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x, endY)).release().perform();
    }

    public void scrollDown() throws MalformedURLException {
        scroll(0.9, 0.1);
    }

    public void scrollUp() throws MalformedURLException {
        scroll(0.1, 0.9);
    }

    public void swipeLeft() throws MalformedURLException {
        swipe(0.9, 0.2);
    }

    public void swipeRight() throws MalformedURLException {
        swipe(0.2, 0.9);
    }

    public void swipe(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2; //meio da altura

        int startX = (int) (size.width * inicio);
        int endX = (int) (size.width * fim);

        new TouchAction(getDriver()).press(PointOption.point(startX, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endX, y)).release().perform();

    }

    public void swipeElement(WebElement element, double inicio, double fim) throws MalformedURLException {

        int y = element.getLocation().y + (element.getSize().height / 2);

        int startX = (int) (element.getSize().width * inicio);
        int endX = (int) (element.getSize().width * fim);

        new TouchAction(getDriver()).press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();

    }

    public void cliqueLongo(By by) throws MalformedURLException {

        MobileElement element = (MobileElement) getDriver().findElement(by);
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(2)))
                .release().perform();

    }
}



